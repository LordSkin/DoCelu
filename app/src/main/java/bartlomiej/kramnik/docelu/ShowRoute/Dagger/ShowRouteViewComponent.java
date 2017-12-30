package bartlomiej.kramnik.docelu.ShowRoute.Dagger;

import bartlomiej.kramnik.docelu.Model.DataModels.Route;
import bartlomiej.kramnik.docelu.ShowRoute.Presenter.ShowRoutePresenterImpl;
import bartlomiej.kramnik.docelu.ShowRoute.View.ShowRouteView;
import dagger.Component;

/**
 * Created by Admin on 30.12.2017.
 */
@Component(modules = ShowRoutePresenterModule.class)
public interface ShowRouteViewComponent {
    public void inject(ShowRoutePresenterImpl presenter);
}
