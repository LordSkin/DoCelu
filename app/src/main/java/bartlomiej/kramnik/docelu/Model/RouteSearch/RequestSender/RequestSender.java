package bartlomiej.kramnik.docelu.Model.RouteSearch.RequestSender;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;
import bartlomiej.kramnik.docelu.Model.RouteSearch.RouteFinderResponseListener;

/**
 * Interface for request sender
 */

public interface RequestSender {

    public void sendRequest(MyPlace origin, MyPlace dest, RouteFinderResponseListener listener);
}
