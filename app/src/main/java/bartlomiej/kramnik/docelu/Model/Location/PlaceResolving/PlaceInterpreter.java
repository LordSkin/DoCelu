package bartlomiej.kramnik.docelu.Model.Location.PlaceResolving;

import org.json.JSONException;
import org.json.JSONObject;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;

/**
 * resolving MyPlace from google api response json
 */

public class PlaceInterpreter {

    public static MyPlace getMyPlace(String place) {
        if(place==null) return null;
        try {
            JSONObject json = new JSONObject(place);
            json = json.getJSONArray("results").getJSONObject(0);
            return new MyPlace(json.getString("formatted_address"), json.getString("place_id"));

        }
        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
