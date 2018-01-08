package bartlomiej.kramnik.docelu.Model.Location.PlaceResolving;

import android.location.Location;

/**
 * sending request to google directions to resolve Place from location
 */

public interface PlaceHelper {
    public void getPlace(Location location, PlaceResponseListener listener);
}
