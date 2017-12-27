package bartlomiej.kramnik.docelu.Model.RouteSearch;

import java.util.List;

import bartlomiej.kramnik.docelu.Model.DataModels.Route;

/**
 * Interface for async route finder
 */

public interface RouteFinderResponseListener {

    public void routeFound(Route r);

    public void routeNotFound();

    public void error(Exception e);
}
