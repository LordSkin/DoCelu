package bartlomiej.kramnik.docelu.Model.Location.PlaceResolving;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;

/**
 * Created by adolf on 07.01.18.
 */

public interface PlaceResponseListener {
    public void placeResolved(MyPlace myPlace);
    public void error(Exception e);
}
