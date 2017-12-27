package bartlomiej.kramnik.docelu.RequestMenagerTests;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;
import bartlomiej.kramnik.docelu.Model.DataModels.Route;
import bartlomiej.kramnik.docelu.Model.RouteSearch.RequestSender.RequestSender;
import bartlomiej.kramnik.docelu.Model.RouteSearch.RequestSender.RequestSenderImpl;
import bartlomiej.kramnik.docelu.Model.RouteSearch.RouteFinderResponseListener;

/**
 * Tests of request sender
 */

@RunWith(AndroidJUnit4.class)
public class RequestSenderTests implements RouteFinderResponseListener {
    private RequestSender requestSender;

    public RequestSenderTests() {
        requestSender = new RequestSenderImpl(InstrumentationRegistry.getTargetContext(), this);
    }

    @Override
    public void routeFound(Route r) {
        Assert.assertTrue(r.getLinesCount()>0);
    }

    @Override
    public void routeNotFound() {
        Assert.fail();
    }

    @Override
    public void error(Exception e) {
        if(!(e instanceof NullPointerException)){
            Assert.fail();
        }
    }

    @Test
    public void findRouteTest1(){
        try {
            MyPlace place1 = new MyPlace(0, "desc", "ChIJsX84rg7qD0cRbdGJB9nC90U");
            MyPlace place2 = new MyPlace(1, "desc2", "ChIJN4s1SMnpD0cRovXBrvxjVA8");
            requestSender.sendRequest(place1, place2);
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void nullTest(){
        try {
            requestSender.sendRequest(null,null);
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
