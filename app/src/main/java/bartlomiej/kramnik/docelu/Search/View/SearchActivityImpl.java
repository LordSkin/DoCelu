package bartlomiej.kramnik.docelu.Search.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import java.util.List;

import javax.inject.Inject;

import bartlomiej.kramnik.docelu.Model.DataModels.Route;
import bartlomiej.kramnik.docelu.R;
import bartlomiej.kramnik.docelu.Search.Dagger.DaggerSearchComponent;
import bartlomiej.kramnik.docelu.Search.Dagger.SearchComponent;
import bartlomiej.kramnik.docelu.Search.Dagger.SearchPresenterModule;
import bartlomiej.kramnik.docelu.Search.Presenter.SearchPresenter;
import bartlomiej.kramnik.docelu.Search.Presenter.SearchPresenterImpl;
import bartlomiej.kramnik.docelu.ShowRoute.View.ShowRouteActivityImpl;

public class SearchActivityImpl extends AppCompatActivity implements SearchView, PlaceSelectionListener, View.OnClickListener, AdapterView.OnItemClickListener {

    PlaceAutocompleteFragment autocompleteFragment;
    TextView from, where;
    Button searchButton;
    ListView lastPlacesList;
    ListAdapter listAdapter;
    ProgressBar progressBar;


    SearchPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);
        from = (TextView) findViewById(R.id.fromTextView);
        where = (TextView) findViewById(R.id.whereTextView);
        searchButton = (Button) findViewById(R.id.searchButton);
        lastPlacesList = (ListView) findViewById(R.id.last_places_list);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        autocompleteFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(this);
        searchButton.setOnClickListener(this);
        presenter = new SearchPresenterImpl();

        SearchPresenterModule module = new SearchPresenterModule(this);
        DaggerSearchComponent.builder().searchPresenterModule(module).build().inject((SearchPresenterImpl) presenter);

        listAdapter = new ListAdapter(this,presenter);
        lastPlacesList.setAdapter(listAdapter);
        lastPlacesList.setOnItemClickListener(this);
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
    public void startActivity(Route route) {
        Intent intent = new Intent(this, ShowRouteActivityImpl.class);
        intent.putExtra("route", route);
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


    //for google autocomplete widget
    @Override
    public void onPlaceSelected(Place place) {
        presenter.selectPlace(place);
    }

    @Override
    public void onError(Status status) {
        Toast.makeText(this, "Error could not find place :/", Toast.LENGTH_SHORT).show();
    }

    //for search button
    @Override
    public void onClick(View v) {
        presenter.search();
    }

    //clicked item in list
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.selectFromList(position);
    }
}
