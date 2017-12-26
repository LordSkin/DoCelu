package bartlomiej.kramnik.docelu.DataBaseTests;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import bartlomiej.kramnik.docelu.Model.DataBase.LastPlaces;
import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;

/**
 * LastPlaces tests
 */

@RunWith(AndroidJUnit4.class)
public class LastPlacesTests {

    private LastPlaces lastPlaces;

    public LastPlacesTests() {
        lastPlaces = new LastPlaces(InstrumentationRegistry.getTargetContext());
    }

    @Test
    public void addTest(){
        try{
            lastPlaces.add(new MyPlace(0, "desc", "asdaf"));
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void addTest2(){
        try{
            lastPlaces.add(null);
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void getTest(){
        try{
            lastPlaces.clear();
            MyPlace testPlace = new MyPlace(0, "desc", "asdaf");
            lastPlaces.add(testPlace);
            Assert.assertEquals(testPlace, lastPlaces.get(0));
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void getTest2(){
        try{
            lastPlaces.clear();
            lastPlaces.get(0);
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void getListTest(){
        try{
            lastPlaces.clear();
            List<MyPlace> places = lastPlaces.getPlacesList();
            Assert.assertEquals(places.size(), 0);

            MyPlace testPlace = new MyPlace(0, "desc", "asdaf");
            lastPlaces.add(testPlace);
            Assert.assertEquals(1, lastPlaces.getPlacesList().size());
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void getListTest2(){
        try{
            lastPlaces.clear();
            MyPlace testPlace = new MyPlace(0, "desc", "asdaf");
            MyPlace testPlace2 = new MyPlace(1, "dfsdfesc", "idasdaf");
            lastPlaces.add(testPlace);
            lastPlaces.add(testPlace2);

            Assert.assertEquals(testPlace, lastPlaces.getPlacesList().get(0));
            Assert.assertEquals(testPlace2, lastPlaces.getPlacesList().get(1));
        }
        catch (Exception e)
        {
            Assert.fail();
        }
    }

}
