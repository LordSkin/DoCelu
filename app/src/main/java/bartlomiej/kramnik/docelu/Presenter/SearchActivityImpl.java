package bartlomiej.kramnik.docelu.Presenter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;

import java.util.List;

import bartlomiej.kramnik.docelu.Presenter.Search.SearchActivity;
import bartlomiej.kramnik.docelu.R;
import bartlomiej.kramnik.docelu.View.SearchViewImpl;

public class SearchActivityImpl extends AppCompatActivity implements SearchActivity {

    PlaceAutocompleteFragment autocompleteFragment;
    TextView from, where;
    Button searchButton;
    SearchViewImpl searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        searchView = SearchViewImpl.getInstance(this);

        setContentView(R.layout.activity_search);
        from = (TextView) findViewById(R.id.fromTextView);
        where = (TextView) findViewById(R.id.whereTextView);
        searchButton = (Button) findViewById(R.id.searchButton);
        autocompleteFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(searchView);

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
        return getContext();
    }
}
