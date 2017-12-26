package bartlomiej.kramnik.docelu.Model.RouteSearch;

import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Managing request sender and providing answer
 */

public class RequestSender implements Response.Listener<String>, Response.ErrorListener {

    Context context;

    public RequestSender(Context context) {
        this.context = context;
    }

    public void sendRequest()//sending request to google directions api
    {

        RequestQueue queue = Volley.newRequestQueue(context);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest("URL", this, this);
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    @Override
    public void onResponse(String response) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
