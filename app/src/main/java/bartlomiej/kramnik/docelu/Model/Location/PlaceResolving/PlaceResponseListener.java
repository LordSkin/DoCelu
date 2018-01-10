package bartlomiej.kramnik.docelu.Model.Location.PlaceResolving;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;

/**
 * Listener for place resolving response
 */

public interface PlaceResponseListener {
    public void placeResolved(MyPlace myPlace);

    public void error(Exception e);
}
