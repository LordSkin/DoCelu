package bartlomiej.kramnik.docelu.Search.Dagger;

import bartlomiej.kramnik.docelu.Model.DataBase.LastPlaces;
import bartlomiej.kramnik.docelu.Model.Location.LocationManager.LocationHelper;
import bartlomiej.kramnik.docelu.Model.Location.LocationManager.LocationHelperImpl;
import bartlomiej.kramnik.docelu.Model.Location.PermissionHelper.PermissionHelper;
import bartlomiej.kramnik.docelu.Model.RouteSearch.RequestSender.RequestSender;
import bartlomiej.kramnik.docelu.Model.RouteSearch.RequestSender.RequestSenderImpl;
import bartlomiej.kramnik.docelu.Search.View.SearchActivityImpl;
import bartlomiej.kramnik.docelu.Search.View.SearchView;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module for Search Presenter
 */

@Module
public class SearchPresenterModule {

    private SearchView view;
    private LastPlaces lastPlaces;
    private RequestSender requestSender;
    private PermissionHelper permissionHelper;
    private LocationHelper locationHelper;

    public SearchPresenterModule(SearchActivityImpl activity) {
        this.view = activity;
        this.lastPlaces = new LastPlaces(activity);
        this.requestSender = new RequestSenderImpl(activity);
        this.permissionHelper = new PermissionHelper(activity);
        locationHelper = LocationHelperImpl.getLocationHelper(activity);
    }

    @Provides
    SearchView provideSearchView() {
        return view;
    }

    @Provides
    LastPlaces provideLastPlaces() {
        return lastPlaces;
    }

    @Provides
    RequestSender provideRequestSender() {
        return requestSender;
    }

    @Provides
    PermissionHelper providesPermissionHelper() {
        return permissionHelper;
    }

    @Provides
    LocationHelper provideLocationHelper() {
        return locationHelper;
    }
}
