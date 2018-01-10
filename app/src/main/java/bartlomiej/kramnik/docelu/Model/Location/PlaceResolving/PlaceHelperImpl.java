package bartlomiej.kramnik.docelu.Model.Location.PlaceResolving;

import android.content.Context;
import android.location.Location;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;

/**
 * Implementation of placeHelper, using google directions api
 */

public class PlaceHelperImpl implements Response.Listener<String>, Response.ErrorListener, PlaceHelper {

    private Context context;
    private PlaceResponseListener listener;
    private final String baseURL = "https://maps.googleapis.com/maps/api/geocode/json?" +
            "&key=AIzaSyBEeyifvklQ5NNCkKdQjdlRLNsJxbvCM6E";

    public PlaceHelperImpl(Context context) {
        this.context = context;
    }

    @Override
    public void getPlace(Location location, PlaceResponseListener listener) {
        this.listener = listener;
        if (location == null) {
            listener.error(new NullPointerException("null Location"));
            return;
        }
        String currUrl = baseURL + "&origin=place_id:" + "&latlng=" + location.getLatitude() + "," + location.getLongitude();
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(currUrl, this, this);
        queue.add(stringRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        listener.error(error);
    }

    @Override
    public void onResponse(String response) {
        MyPlace result = PlaceInterpreter.getMyPlace(response);
        if (result == null) {
            listener.error(new Exception("interpreter error"));
        } else {
            listener.placeResolved(result);
        }
    }
}
