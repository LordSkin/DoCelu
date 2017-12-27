package bartlomiej.kramnik.docelu.Model.RouteSearch.RequestSender;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;

/**
 * Interface for request sender
 */

public interface RequestSender {

    public void sendRequest(MyPlace origin, MyPlace dest);
}
