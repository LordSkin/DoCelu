package bartlomiej.kramnik.docelu.ShowRoute.Presenter;

import android.graphics.drawable.Icon;
import android.media.Image;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.zip.Inflater;

import javax.inject.Inject;

import bartlomiej.kramnik.docelu.Model.DataModels.Line;
import bartlomiej.kramnik.docelu.Model.DataModels.Route;
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


    @Override
    public void loadView() {
        LinearLayout linearLayout = new LinearLayout(view.getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ScrollView scrollView = new ScrollView(view.getContext());
        scrollView.addView(linearLayout);

        LayoutInflater inflater = LayoutInflater.from(view.getContext());

        for(Line l : route.getLineList()){
            linearLayout.addView(inflater.inflate(R.layout.arrow_down,null));
            linearLayout.addView(l.getView(inflater));
        }

        view.showView(scrollView);
    }
}
