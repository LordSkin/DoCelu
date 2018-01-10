package bartlomiej.kramnik.docelu.LocationTests;

import android.support.test.InstrumentationRegistry;

import org.junit.Assert;
import org.junit.Test;

import bartlomiej.kramnik.docelu.Model.Location.LocationManager.LocationHelper;
import bartlomiej.kramnik.docelu.Model.Location.LocationManager.LocationHelperImpl;

/**
 * tests of locationHelper
 */

public class LocationHelperTests {

    LocationHelper locationHelper;

    public LocationHelperTests() {
        locationHelper = LocationHelperImpl.getLocationHelper(InstrumentationRegistry.getTargetContext());
    }

    @Test
    public void locationTest1(){
        try {
            locationHelper.getLocation(null);
        }
        catch (Exception e){
            Assert.fail();
        }
    }
}
