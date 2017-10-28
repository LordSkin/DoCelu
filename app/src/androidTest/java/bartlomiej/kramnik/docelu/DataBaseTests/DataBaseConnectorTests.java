package bartlomiej.kramnik.docelu.DataBaseTests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import bartlomiej.kramnik.docelu.Model.DataBase.DataBaseConnector;
import bartlomiej.kramnik.docelu.Model.DataBase.DataBaseConnectorImpl;

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
}
