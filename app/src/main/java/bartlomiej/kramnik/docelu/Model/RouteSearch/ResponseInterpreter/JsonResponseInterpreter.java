package bartlomiej.kramnik.docelu.Model.RouteSearch.ResponseInterpreter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import bartlomiej.kramnik.docelu.Model.DataModels.Transport.Line;
import bartlomiej.kramnik.docelu.Model.DataModels.Route;
import bartlomiej.kramnik.docelu.Model.DataModels.Transport.Transport;
import bartlomiej.kramnik.docelu.Model.DataModels.Transport.Walking;

/**
 * Interpreting response from google API
 */

public class JsonResponseInterpreter {

    public static Route getRoute(String s) {
        try {
            JSONObject json = new JSONObject(s);
            JSONArray array = json.getJSONArray("routes");
            json = array.getJSONObject(0);
            array = json.getJSONArray("legs");
            json = array.getJSONObject(0);
            array = json.getJSONArray("steps");

            List<Transport> lines = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                json = array.getJSONObject(i);
                String type = json.getString("travel_mode");
                if (type.equals("TRANSIT")) {
                    json = json.getJSONObject("transit_details");

                    lines.add(new Line(json.getJSONObject("line").getString("short_name"),
                            json.getJSONObject("departure_stop").getString("name"),
                            json.getJSONObject("arrival_stop").getString("name"),
                            json.getInt("num_stops"),
                            json.getJSONObject("line").getJSONObject("vehicle").getString("type")));
                }
                if (type.equals("WALKING")) {
                    lines.add(new Walking(json.getString("html_instructions")));
                }
            }
            return new Route(lines);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
