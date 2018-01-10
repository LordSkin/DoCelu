package bartlomiej.kramnik.docelu.Search.Presenter;

import android.location.Location;

import com.google.android.gms.location.places.Place;

import javax.inject.Inject;

import bartlomiej.kramnik.docelu.Model.DataBase.LastPlaces;
import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;
import bartlomiej.kramnik.docelu.Model.DataModels.Route;
import bartlomiej.kramnik.docelu.Model.Location.LocationManager.LocationHelper;
import bartlomiej.kramnik.docelu.Model.Location.LocationManager.LocationHelperImpl;
import bartlomiej.kramnik.docelu.Model.Location.LocationManager.LocationMangerListener;
import bartlomiej.kramnik.docelu.Model.Location.PermissionHelper.PermissionHelper;
import bartlomiej.kramnik.docelu.Model.Location.PermissionHelper.PermissionRequestResponseListener;
import bartlomiej.kramnik.docelu.Model.RouteSearch.RequestSender.RequestSender;
import bartlomiej.kramnik.docelu.Model.RouteSearch.RouteFinderResponseListener;
import bartlomiej.kramnik.docelu.R;
import bartlomiej.kramnik.docelu.Search.View.SearchActivityImpl;
import bartlomiej.kramnik.docelu.Search.View.SearchView;

/**
 * Implementation of search presenter
 */

public class SearchPresenterImpl implements SearchPresenter, RouteFinderResponseListener, PermissionRequestResponseListener, LocationMangerListener {

    @Inject
    SearchView view;

    @Inject
    LastPlaces lastPlaces;

    @Inject
    RequestSender requestSender;

    @Inject
    PermissionHelper permissionHelper;

    @Inject
    LocationHelper locationHelper;

    private MyPlace from, where;

    private static final int SELECTED_FROM = 0;
    private static final int SELECTED_WHERE = 1;

    private int selected = SELECTED_FROM;

    @Override
    public void selectPlace(Place place) {
        MyPlace temp = new MyPlace(place.getName().toString(), place.getId().toString());
        if (selected == SELECTED_FROM) {
            from = temp;
            view.showFrom(from.getDescription());
            selected = SELECTED_WHERE;
            view.selectWhere();
        } else {
            where = temp;
            view.showWhere(where.getDescription());
        }
    }

    @Override
    public void selectFromList(int id) {
        MyPlace temp = lastPlaces.get(id);
        if (selected == SELECTED_FROM) {
            from = temp;
            view.showFrom(from.getDescription());
            selected = SELECTED_WHERE;
            view.selectWhere();
        } else {
            where = temp;
            view.showWhere(where.getDescription());
        }
    }

    @Override
    public void fromSelected() {
        selected = SELECTED_FROM;
        view.selectFrom();
    }

    @Override
    public void whereSelected() {
        selected = SELECTED_WHERE;
        view.selectWhere();
    }

    @Override
    public void search() {
        if (from == null || where == null) {
            view.showError(R.string.emptyPlace);
        } else {
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

    @Override
    public void useLocation() {
        if (permissionHelper.chechkLocationPermission()) {
            view.showLoadingIndicator();
            if (!locationHelper.isEnabled()) locationHelper.enable();
            locationHelper.getLocation(this);
        } else {
            permissionHelper.requestPermission(this);
        }

    }

    @Override
    public void permissionResponse(int requestCode, String[] permissions, int[] grantResults) {
        permissionHelper.permissionResult(requestCode, permissions, grantResults);
    }

    //from requestSender
    @Override
    public void routeFound(Route r) {
        lastPlaces.add(from);
        lastPlaces.add(where);
        view.hideLoadingIndicator();
        view.startActivity(r, from.getDescription(), where.getDescription());
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


    // permision requests
    @Override
    public void permissionsGranted() {
        useLocation();
    }

    @Override
    public void permissionsDenied() {
        view.showError(R.string.permissionRequired);
    }


    //from locationHelper
    @Override
    public void locationFound(MyPlace place) {
        from = place;
        view.showFrom(place.getDescription());
        view.hideLoadingIndicator();
    }

    @Override
    public void locationError(Exception e) {
        view.showError(R.string.error);
        view.hideLoadingIndicator();
    }
}
