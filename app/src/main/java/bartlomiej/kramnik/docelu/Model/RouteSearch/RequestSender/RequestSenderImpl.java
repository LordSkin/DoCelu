package bartlomiej.kramnik.docelu.Model.RouteSearch.RequestSender;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;
import bartlomiej.kramnik.docelu.Model.DataModels.Route;
import bartlomiej.kramnik.docelu.Model.RouteSearch.ResponseInterpreter.JsonResponseInterpreter;
import bartlomiej.kramnik.docelu.Model.RouteSearch.RouteFinderResponseListener;

/**
 * Managing request sender and providing answer
 */

public class RequestSenderImpl implements Response.Listener<String>, Response.ErrorListener, RequestSender {

    private Context context;
    private RouteFinderResponseListener listener;
    private final String baseURL = "https://maps.googleapis.com/maps/api/directions/json?" +
            "mode=transit&alternatives=false&language=pl&key=AIzaSyBEeyifvklQ5NNCkKdQjdlRLNsJxbvCM6E";

    public RequestSenderImpl(Context context) {
        this.context = context;
    }

    /**
     * Send request async. Answer is deliwered to listener
     *
     * @param origin
     * @param dest
     */
    @Override
    public void sendRequest(MyPlace origin, MyPlace dest, RouteFinderResponseListener listener)//sending request to google directions api
    {
        this.listener = listener;
        if (origin == null || dest == null) {
            listener.error(new NullPointerException("Null Place"));
            return;
        }
        String currUrl = baseURL + "&origin=place_id:" + origin.getPlaceID() + "&destination=place_id:" + dest.getPlaceID();
        RequestQueue queue = Volley.newRequestQueue(context);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(currUrl, this, this);
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    @Override
    public void onResponse(String response) {
        Route route = JsonResponseInterpreter.getRoute(response);
        if (route != null) {
            listener.routeFound(route);
        } else {
            listener.routeNotFound();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        listener.error(error);
    }
}
