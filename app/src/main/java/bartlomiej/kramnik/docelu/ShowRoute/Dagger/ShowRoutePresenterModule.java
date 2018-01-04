package bartlomiej.kramnik.docelu.ShowRoute.Dagger;

import bartlomiej.kramnik.docelu.Model.DataModels.Route;
import bartlomiej.kramnik.docelu.ShowRoute.View.ShowRouteView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 30.12.2017.
 */

@Module
public class ShowRoutePresenterModule {

    private ShowRouteView view;
    private Route route;

    public ShowRoutePresenterModule(ShowRouteView view, Route route) {
        this.view = view;
        this.route = route;
    }

    @Provides
    public Route routeProvide(){
        return route;
    }

    @Provides
    public ShowRouteView showRouteViewProvide(){
        return view;
    }

}
