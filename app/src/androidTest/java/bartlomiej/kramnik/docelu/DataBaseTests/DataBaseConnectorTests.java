package bartlomiej.kramnik.docelu.DataBaseTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import bartlomiej.kramnik.docelu.Model.DataBase.DataBaseConnector;
import bartlomiej.kramnik.docelu.Model.DataBase.DataBaseConnectorImpl;
import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;

/**
 * DataBase connector tests
 */

@RunWith(AndroidJUnit4.class)
public class DataBaseConnectorTests {
    private DataBaseConnector dataBaseConnector;
    private Context context;

    public DataBaseConnectorTests() {
        context = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void creatingTest() {
        try {
            dataBaseConnector = new DataBaseConnectorImpl(context);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void readEmptyTest() {
        dataBaseConnector = new DataBaseConnectorImpl(context);
        try {
            dataBaseConnector.getPlace(0);
            dataBaseConnector.getPlace(-1);
            dataBaseConnector.getPlace(1);
            dataBaseConnector.getPlaces();
        }
        catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void addTest(){
        try
        {
            dataBaseConnector = new DataBaseConnectorImpl(context);
            dataBaseConnector.clearPlaces();
            MyPlace testPlace = new MyPlace( "dfytvescription", "id");
            MyPlace testPlace2 = new MyPlace("deshgvhgcription", "id");
            dataBaseConnector.addPlace(testPlace);
            dataBaseConnector.addPlace(testPlace2);
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void addTestNull(){
        try{
            dataBaseConnector = new DataBaseConnectorImpl(context);
            dataBaseConnector.addPlace(null);
            Assert.fail();
        }
        catch (NullPointerException e){

        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void getTest(){
        try
        {
            dataBaseConnector = new DataBaseConnectorImpl(context);
            dataBaseConnector.clearPlaces();
            MyPlace testPlace = new MyPlace( "dfytvescription", "id");
            MyPlace testPlace2 = new MyPlace( "dfytvrgrtgiption", "id2");
            dataBaseConnector.addPlace(testPlace);
            dataBaseConnector.addPlace(testPlace2);
            Assert.assertEquals(testPlace, dataBaseConnector.getPlace(0));
            Assert.assertEquals(testPlace2, dataBaseConnector.getPlace(1));
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void getTest2(){
        try{
            dataBaseConnector = new DataBaseConnectorImpl(context);
            dataBaseConnector.clearPlaces();
            MyPlace p = dataBaseConnector.getPlace(0);
            Assert.assertNull(p);
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void getPlacesTest(){
        try{
            dataBaseConnector = new DataBaseConnectorImpl(context);
            dataBaseConnector.clearPlaces();
            MyPlace testPlace = new MyPlace( "dfytvescription", "id");
            MyPlace testPlace2 = new MyPlace("dfytvrgrtgiption", "id2");
            dataBaseConnector.addPlace(testPlace);
            dataBaseConnector.addPlace(testPlace2);

            List<MyPlace> places = dataBaseConnector.getPlaces();
            Assert.assertEquals(2, places.size());
            Assert.assertEquals(places.get(0), testPlace);
            Assert.assertEquals(places.get(1), testPlace2);
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void getPlacesTest2(){
        try{
            dataBaseConnector = new DataBaseConnectorImpl(context);
            dataBaseConnector.clearPlaces();
            List<MyPlace> places = dataBaseConnector.getPlaces();
            Assert.assertEquals(0, places.size());
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void deletePlacesTest(){
        try{
            dataBaseConnector = new DataBaseConnectorImpl(context);
            dataBaseConnector.clearPlaces();
            MyPlace testPlace = new MyPlace( "dfytvescription", "id");
            MyPlace testPlace2 = new MyPlace( "dfytvrgrtgiption", "id2");
            dataBaseConnector.addPlace(testPlace);
            dataBaseConnector.addPlace(testPlace2);

            dataBaseConnector.deletePlace(testPlace);
            Assert.assertEquals(1, dataBaseConnector.getPlaces().size());

            dataBaseConnector.deletePlace(0);
            Assert.assertEquals(0, dataBaseConnector.getPlaces().size());
        }
        catch (Exception e){
            Assert.fail();
        }
    }

}
