package bartlomiej.kramnik.docelu.Model.Location.LocationManager;

import com.google.android.gms.location.places.Place;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;

/**
 * Interface for location response listener
 */

public interface LocationMangerListener {

    public void locationFound(MyPlace place);

    public void locationError(Exception e);
}
