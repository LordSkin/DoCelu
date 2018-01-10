package bartlomiej.kramnik.docelu.LocationTests.PlaceResolvingtests;

import org.junit.Assert;
import org.junit.Test;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;
import bartlomiej.kramnik.docelu.Model.Location.PlaceResolving.PlaceInterpreter;

/**
 * Tets of placeInterpreter
 */

public class PlaceInterpreterTets {

    @Test
    public void InterpreterTest1(){
        MyPlace place = PlaceInterpreter.getMyPlace(testLocation);
        Assert.assertEquals(place.getDescription(), "Austria");
    }

    @Test
    public void interpretertests2(){
        Assert.assertNull(PlaceInterpreter.getMyPlace("asdwfgw78efd978edy3hwdg9780qw9suyxwe0g90gtd"));
    }

    @Test
    public void nullTest(){
        try {
            MyPlace place = PlaceInterpreter.getMyPlace(null);
            Assert.assertNull(place);
        }
        catch (Exception e){
            Assert.fail();
        }
    }


  final String testLocation = "{\n" +
          "   \"results\" : [\n" +
          "      {\n" +
          "         \"address_components\" : [\n" +
          "            {\n" +
          "               \"long_name\" : \"Austria\",\n" +
          "               \"short_name\" : \"AT\",\n" +
          "               \"types\" : [ \"country\", \"political\" ]\n" +
          "            }\n" +
          "         ],\n" +
          "         \"formatted_address\" : \"Austria\",\n" +
          "         \"geometry\" : {\n" +
          "            \"bounds\" : {\n" +
          "               \"northeast\" : {\n" +
          "                  \"lat\" : 49.0206081,\n" +
          "                  \"lng\" : 17.1606861\n" +
          "               },\n" +
          "               \"southwest\" : {\n" +
          "                  \"lat\" : 46.37233579999999,\n" +
          "                  \"lng\" : 9.530783399999999\n" +
          "               }\n" +
          "            },\n" +
          "            \"location\" : {\n" +
          "               \"lat\" : 47.516231,\n" +
          "               \"lng\" : 14.550072\n" +
          "            },\n" +
          "            \"location_type\" : \"APPROXIMATE\",\n" +
          "            \"viewport\" : {\n" +
          "               \"northeast\" : {\n" +
          "                  \"lat\" : 49.0206081,\n" +
          "                  \"lng\" : 17.1606861\n" +
          "               },\n" +
          "               \"southwest\" : {\n" +
          "                  \"lat\" : 46.37233579999999,\n" +
          "                  \"lng\" : 9.530783399999999\n" +
          "               }\n" +
          "            }\n" +
          "         },\n" +
          "         \"place_id\" : \"ChIJfyqdJZsHbUcRr8Hk3XvUEhA\",\n" +
          "         \"types\" : [ \"country\", \"political\" ]\n" +
          "      }\n" +
          "   ],\n" +
          "   \"status\" : \"OK\"\n" +
          "}";
}
