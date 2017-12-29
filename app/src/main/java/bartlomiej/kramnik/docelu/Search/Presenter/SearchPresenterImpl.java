package bartlomiej.kramnik.docelu.Search.Presenter;

import com.google.android.gms.location.places.Place;

import javax.inject.Inject;

import bartlomiej.kramnik.docelu.Model.DataBase.LastPlaces;
import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;
import bartlomiej.kramnik.docelu.Model.DataModels.Route;
import bartlomiej.kramnik.docelu.Model.RouteSearch.RequestSender.RequestSender;
import bartlomiej.kramnik.docelu.Model.RouteSearch.RouteFinderResponseListener;
import bartlomiej.kramnik.docelu.R;
import bartlomiej.kramnik.docelu.Search.View.SearchView;

/**
 * Implementation of search presenter
 */

public class SearchPresenterImpl implements SearchPresenter, RouteFinderResponseListener {

    @Inject
    SearchView view;

    @Inject
    LastPlaces lastPlaces;

    @Inject
    RequestSender requestSender;

    private MyPlace from, where;

    @Override
    public void selectPlace(Place place) {
        MyPlace temp = new MyPlace(place.getAddress().toString(), place.getId().toString());
        if (from == null) {
            from = temp;
            view.showFrom(from.getDescription());
        }
        else {
            where = temp;
            view.showWhere(where.getDescription());
        }
    }

    @Override
    public void selectFromList(int id) {
        MyPlace temp = lastPlaces.get(id);
        if (from == null) {
            from = temp;
            view.showFrom(from.getDescription());
        }
        else {
            where = temp;
            view.showWhere(where.getDescription());
        }
    }

    @Override
    public void search() {
        if (from == null || where == null) {
            view.showError(R.string.emptyPlace);
        }
        else {
            view.showLoadingIndicator();
            requestSender.sendRequest(from, where, this);
        }
    }

    @Override
    public MyPlace getLastPlace(int id) {
        return lastPlaces.get(id);
    }

    @Override
    public int getlastPlacesCount() {
        return lastPlaces.getPlacesList().size();
    }

    //from requestSender
    @Override
    public void routeFound(Route r) {
        lastPlaces.add(from);
        lastPlaces.add(where);
        view.hideLoadingIndicator();
        view.startActivity(r);
    }

    @Override
    public void routeNotFound() {
        view.hideLoadingIndicator();
        view.showError(R.string.routeNotFound);
    }

    @Override
    public void error(Exception e) {
        view.hideLoadingIndicator();
        view.showError(R.string.error);
    }
}
