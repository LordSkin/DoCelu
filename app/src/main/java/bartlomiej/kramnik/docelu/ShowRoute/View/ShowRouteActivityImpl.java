package bartlomiej.kramnik.docelu.ShowRoute.View;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import bartlomiej.kramnik.docelu.Model.DataModels.Route;
import bartlomiej.kramnik.docelu.R;
import bartlomiej.kramnik.docelu.ShowRoute.Dagger.DaggerShowRouteViewComponent;
import bartlomiej.kramnik.docelu.ShowRoute.Dagger.ShowRoutePresenterModule;
import bartlomiej.kramnik.docelu.ShowRoute.Presenter.ShowRoutePresenter;
import bartlomiej.kramnik.docelu.ShowRoute.Presenter.ShowRoutePresenterImpl;

public class ShowRouteActivityImpl extends AppCompatActivity implements ShowRouteView {

    ShowRoutePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_show_route_impl);

        Route r = (Route) getIntent().getExtras().get("route");

        presenter = new ShowRoutePresenterImpl();

        DaggerShowRouteViewComponent.builder().showRoutePresenterModule(new ShowRoutePresenterModule(this, r)).build().inject((ShowRoutePresenterImpl) presenter);

        presenter.loadView();

    }


    @Override
    public void showView(View view) {
        setContentView(view);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
