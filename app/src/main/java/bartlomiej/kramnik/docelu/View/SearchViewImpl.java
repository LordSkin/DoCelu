package bartlomiej.kramnik.docelu.View;

import android.util.Log;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import bartlomiej.kramnik.docelu.Presenter.Search.SearchActivity;
import bartlomiej.kramnik.docelu.Presenter.SearchActivityImpl;

/**
 * View for searching places. Connected with SearchActivityImpl
 */

public class SearchViewImpl implements PlaceSelectionListener, SearchView {

    private static SearchViewImpl searchView;

    public static SearchViewImpl getInstance(SearchActivity activity) {
        if(searchView==null){
            searchView = new SearchViewImpl(activity);
        }
        return searchView;
    }

    SearchActivity activity;

    public SearchViewImpl(SearchActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onPlaceSelected(Place place) {
        Log.d("aa", place.toString());
    }

    @Override
    public void onError(Status status) {

    }

    @Override
    public void searchButtonClicked() {

    }
}
