package bartlomiej.kramnik.docelu.ShowRoute.Presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import javax.inject.Inject;

import bartlomiej.kramnik.docelu.Model.DataModels.Route;
import bartlomiej.kramnik.docelu.Model.DataModels.Transport.Transport;
import bartlomiej.kramnik.docelu.R;
import bartlomiej.kramnik.docelu.ShowRoute.View.ShowRouteView;

/**
 * Show route presenter implementation
 */

public class ShowRoutePresenterImpl implements ShowRoutePresenter {

    @Inject
    ShowRouteView view;

    @Inject
    Route route;

    private String from, where;

    public ShowRoutePresenterImpl(String from, String where) {
        this.from = from;
        this.where = where;
    }

    @Override
    public void loadView() {
        LinearLayout linearLayout = new LinearLayout(view.getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ScrollView scrollView = new ScrollView(view.getContext());
        scrollView.addView(linearLayout);

        LayoutInflater inflater = LayoutInflater.from(view.getContext());

        View start = inflater.inflate(R.layout.stop_name, null);
        ((TextView) start.findViewById(R.id.stopName)).setText(from);
        linearLayout.addView(start);

        for (Transport l : route.getLineList()) {
            linearLayout.addView(inflater.inflate(R.layout.arrow_down, null));
            linearLayout.addView(l.getView(inflater));
        }

        linearLayout.addView(inflater.inflate(R.layout.arrow_down, null));
        View stop = inflater.inflate(R.layout.stop_name, null);
        ((TextView) stop.findViewById(R.id.stopName)).setText(where);
        linearLayout.addView(stop);
        linearLayout.addView(inflater.inflate(R.layout.powered_by_google, null));

        view.showView(scrollView);
    }
}
