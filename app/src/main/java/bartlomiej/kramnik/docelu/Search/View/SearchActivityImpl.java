package bartlomiej.kramnik.docelu.Search.View;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import java.util.List;

import javax.inject.Inject;

import bartlomiej.kramnik.docelu.R;
import bartlomiej.kramnik.docelu.Search.Dagger.DaggerSearchComponent;
import bartlomiej.kramnik.docelu.Search.Dagger.SearchComponent;
import bartlomiej.kramnik.docelu.Search.Dagger.SearchPresenterModule;
import bartlomiej.kramnik.docelu.Search.Presenter.SearchPresenter;
import bartlomiej.kramnik.docelu.Search.Presenter.SearchPresenterImpl;

public class SearchActivityImpl extends AppCompatActivity implements SearchView, PlaceSelectionListener, View.OnClickListener {

    PlaceAutocompleteFragment autocompleteFragment;
    TextView from, where;
    Button searchButton;


    SearchPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SearchComponent component = DaggerSearchComponent.builder().build();
        component.inject(this);

        setContentView(R.layout.activity_search);
        from = (TextView) findViewById(R.id.fromTextView);
        where = (TextView) findViewById(R.id.whereTextView);
        searchButton = (Button) findViewById(R.id.searchButton);
        autocompleteFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(this);
        searchButton.setOnClickListener(this);
        presenter = new SearchPresenterImpl();

    }

    @Override
    public void showError(Error e) {
        Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadList(List<Place> places) {

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


    //for google autocomplete widget
    @Override
    public void onPlaceSelected(Place place) {
        Toast.makeText(this, place.getAddress(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Status status) {
        Toast.makeText(this, "Error could not find place :/", Toast.LENGTH_SHORT).show();
    }

    //for search button
    @Override
    public void onClick(View v) {

    }
}
