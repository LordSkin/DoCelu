package bartlomiej.kramnik.docelu.Search.Presenter;

import com.google.android.gms.location.places.Place;

import javax.inject.Inject;

import bartlomiej.kramnik.docelu.Model.DataBase.LastPlaces;
import bartlomiej.kramnik.docelu.Model.RouteSearch.RequestSender.RequestSender;
import bartlomiej.kramnik.docelu.Search.View.SearchView;

/**
 * Implementation of search presenter
 */

public class SearchPresenterImpl implements SearchPresenter {

    @Inject
    SearchView view;

    @Inject
    LastPlaces lastPlaces;

    @Inject
    RequestSender requestSender;

    @Override
    public void selectPlace(Place place) {

    }

    @Override
    public void selectFromList(int id) {

    }

    @Override
    public void search() {

    }
}
