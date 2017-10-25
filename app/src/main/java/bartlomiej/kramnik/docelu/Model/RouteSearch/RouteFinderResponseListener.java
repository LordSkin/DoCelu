package bartlomiej.kramnik.docelu.Model.RouteSearch;

import java.util.List;

import bartlomiej.kramnik.docelu.Model.DataModels.Route;

/**
 * Created by Admin on 24.10.2017.
 */

public interface RouteFinderResponseListener {

    public void routeFound(Route r);

    public void routeNotFound();

    public void error();
}
