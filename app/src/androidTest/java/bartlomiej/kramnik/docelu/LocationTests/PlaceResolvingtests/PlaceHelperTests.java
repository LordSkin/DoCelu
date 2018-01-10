package bartlomiej.kramnik.docelu.LocationTests.PlaceResolvingtests;

import android.location.Location;
import android.support.test.InstrumentationRegistry;

import junit.framework.Assert;

import org.junit.Test;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;
import bartlomiej.kramnik.docelu.Model.Location.PlaceResolving.PlaceHelper;
import bartlomiej.kramnik.docelu.Model.Location.PlaceResolving.PlaceHelperImpl;
import bartlomiej.kramnik.docelu.Model.Location.PlaceResolving.PlaceResponseListener;

/**
 * Tests of placeHelper
 */

public class PlaceHelperTests{
    PlaceHelper placeHelper;

    public PlaceHelperTests() {
        placeHelper = new PlaceHelperImpl(InstrumentationRegistry.getTargetContext());

    }



    @Test
    public void nullLocationTest(){

        try{
            placeHelper.getPlace(null, new PlaceResponseListener() {
                @Override
                public void placeResolved(MyPlace myPlace) {
                    Assert.fail();
                }

                @Override
                public void error(Exception e) {
                    Assert.assertEquals(e.getMessage(), "null Location");
                }
            });
            Thread.sleep(5000);
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void nullListenerTest(){
        try {
            placeHelper.getPlace(null, null);
        }
        catch (Exception e){
            Assert.fail();
        }
    }


}
