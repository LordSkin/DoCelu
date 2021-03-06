package bartlomiej.kramnik.docelu.Search.View;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.VisibleForTesting;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import java.util.List;

import javax.inject.Inject;

import bartlomiej.kramnik.docelu.Model.DataBase.LastPlaces;
import bartlomiej.kramnik.docelu.Model.DataModels.Route;
import bartlomiej.kramnik.docelu.R;
import bartlomiej.kramnik.docelu.Search.Dagger.DaggerSearchComponent;
import bartlomiej.kramnik.docelu.Search.Dagger.SearchAdapterModule;
import bartlomiej.kramnik.docelu.Search.Dagger.SearchComponent;
import bartlomiej.kramnik.docelu.Search.Dagger.SearchPresenterModule;
import bartlomiej.kramnik.docelu.Search.Presenter.SearchPresenter;
import bartlomiej.kramnik.docelu.Search.Presenter.SearchPresenterImpl;
import bartlomiej.kramnik.docelu.ShowRoute.View.ShowRouteActivityImpl;

import static com.google.android.gms.location.places.AutocompleteFilter.TYPE_FILTER_CITIES;

public class SearchActivityImpl extends AppCompatActivity implements SearchView, PlaceSelectionListener, View.OnClickListener, AdapterView.OnItemClickListener {

    PlaceAutocompleteFragment autocompleteFragment;
    TextView from, where;
    ListView lastPlacesList;
    ListAdapter listAdapter;
    ProgressBar progressBar;
    FloatingActionButton locationButton ,searchButton;
    View viewBorder;


    SearchPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);
        from = (TextView) findViewById(R.id.fromTextView);
        from.setOnClickListener(this);
        where = (TextView) findViewById(R.id.whereTextView);
        where.setOnClickListener(this);
        searchButton = (FloatingActionButton) findViewById(R.id.searchButton);
        lastPlacesList = (ListView) findViewById(R.id.last_places_list);
        locationButton = (FloatingActionButton) findViewById(R.id.localisation);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        autocompleteFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(this);

        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                .setTypeFilter(AutocompleteFilter.TYPE_FILTER_ADDRESS)
                .setCountry("PL")
                .build();
        autocompleteFragment.setFilter(typeFilter);

        locationButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);
        presenter = new SearchPresenterImpl();
        listAdapter = new ListAdapter(this);

        SearchPresenterModule module = new SearchPresenterModule(this);
        SearchAdapterModule module2 = new SearchAdapterModule(presenter);


        SearchComponent component = DaggerSearchComponent.builder().searchPresenterModule(module).searchAdapterModule(module2).build();
        component.inject((SearchPresenterImpl) presenter);
        component.inject(listAdapter);

        lastPlacesList.setAdapter(listAdapter);
        lastPlacesList.setOnItemClickListener(this);

        from.setBackgroundResource(R.layout.view_border);
    }

    @VisibleForTesting
    public SearchPresenterImpl getPresenter(){
        return (SearchPresenterImpl)presenter;
    }

    @Override
    public void showError(int e) {
        Toast.makeText(this, this.getString(e), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void reLoadList() {
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void showFrom(String s) {
        from.setText(s);
    }

    @Override
    public void showWhere(String s) {
        where.setText(s);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void startActivity(Route route, String from, String where) {
        Intent intent = new Intent(this, ShowRouteActivityImpl.class);
        intent.putExtra("route", route);
        intent.putExtra("from", from);
        intent.putExtra("where", where);
        startActivity(intent);

    }

    @Override
    public void showLoadingIndicator() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void selectFrom() {
        from.setBackgroundResource(R.layout.view_border);
        where.setBackground(null);
    }

    @Override
    public void selectWhere() {
        from.setBackground(null);
        where.setBackgroundResource(R.layout.view_border);
    }

    @Override
    public void selectNone() {
        where.setBackground(null);
        from.setBackground(null);
    }


    //for google autocomplete widget
    @Override
    public void onPlaceSelected(Place place) {
        presenter.selectPlace(place);
    }

    @Override
    public void onError(Status status) {
        Toast.makeText(this, this.getString(R.string.routeNotFound), Toast.LENGTH_SHORT).show();
    }

    //from onClickListener
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.searchButton){
            presenter.search();
        }
        if (view.getId()==R.id.localisation){
            presenter.useLocation();
        }
        if(view.getId()==R.id.fromTextView){
            presenter.fromSelected();
        }
        if (view.getId()==R.id.whereTextView){
            presenter.whereSelected();
        }

    }

    //clicked item in list
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.selectFromList(position);
    }

    //required to obtain permissions
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        presenter.permissionResponse(requestCode, permissions, grantResults);
    }
}
