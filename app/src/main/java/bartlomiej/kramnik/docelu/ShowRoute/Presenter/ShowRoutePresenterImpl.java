package bartlomiej.kramnik.docelu.ShowRoute.Presenter;

import android.graphics.drawable.Icon;
import android.media.Image;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        for(Line l : route.getLineList()){

            ImageView arrow = new ImageView(view.getContext());
            arrow.setImageResource(R.drawable.arrow_down);

            LinearLayout cell = new LinearLayout(view.getContext());
            cell.setOrientation(LinearLayout.HORIZONTAL);

            TextView stopName = new TextView(view.getContext());
            stopName.setText(l.getFrom());

            ImageView vechicleType = new ImageView(view.getContext());
            if(l.getVechicleType()==Line.BUS){
                vechicleType.setImageResource(R.drawable.bus);
            }
            if(l.getVechicleType()==Line.TRAMWAJ){
                vechicleType.setImageResource(R.drawable.tram);
            }

            TextView stopsNum = new TextView(view.getContext());
            stopName.setText(l.getNumStops()+" przystanków");

            cell.addView(stopName);
            cell.addView(vechicleType);
            cell.addView(stopsNum);

            linearLayout.addView(arrow);
            linearLayout.addView(cell);
        }

        view.showView(linearLayout);
    }
}
