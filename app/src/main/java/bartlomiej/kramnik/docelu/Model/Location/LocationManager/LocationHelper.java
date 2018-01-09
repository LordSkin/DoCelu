package bartlomiej.kramnik.docelu.Model.Location.LocationManager;

import android.location.Location;

/**
 * Manager for providing current location
 */

public interface LocationHelper {
    public void getLocation(LocationMangerListener listener);

    public boolean isEnabled();

    public void enable();
}
