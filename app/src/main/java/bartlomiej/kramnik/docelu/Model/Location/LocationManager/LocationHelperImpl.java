package bartlomiej.kramnik.docelu.Model.Location.LocationManager;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.location.places.PlaceLikelihood;

import java.util.List;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;
import bartlomiej.kramnik.docelu.Model.Location.PlaceResolving.PlaceHelper;
import bartlomiej.kramnik.docelu.Model.Location.PlaceResolving.PlaceHelperImpl;
import bartlomiej.kramnik.docelu.Model.Location.PlaceResolving.PlaceInterpreter;
import bartlomiej.kramnik.docelu.Model.Location.PlaceResolving.PlaceResponseListener;

import static android.content.Context.LOCATION_SERVICE;

/**
 * providing current GPS location
 */

public class LocationHelperImpl implements LocationListener, LocationHelper, PlaceResponseListener {

    private LocationMangerListener listener;
    private Location location;
    private Context context;
    private LocationManager locationManager;
    private long minTime = 60000; //minimum time interval between location updates, in milliseconds
    private float minDist = 1000; //minimum distance between location updates, in meters
    private PlaceHelper placeHelper;
    private boolean isEnabled;

    private static LocationHelper locationHelperSingleton;

    public static LocationHelper getLocationHelper(Context context){
        if (locationHelperSingleton==null){
            locationHelperSingleton = new LocationHelperImpl(context);
            return locationHelperSingleton;
        }
        else {
            return locationHelperSingleton;
        }
    }


    private LocationHelperImpl(Context context) {
        isEnabled = false;
        if(context!=null)
        {
            placeHelper = new PlaceHelperImpl(context);
            this.context = context;

        }
    }

    private Location getLastKnownLocation() {
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = locationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                bestLocation = l;
            }
        }
        return bestLocation;
    }


    @Override
    public void onLocationChanged(Location location) {
        this.location = location;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    //geting location methods

    @Override
    public void getLocation(LocationMangerListener listener) {
        this.listener = listener;
        placeHelper.getPlace(location, this);
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public void enable() {
        locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, minTime, minDist, this);
        location = getLastKnownLocation();
        isEnabled = true;
    }

    //responses from google api


    @Override
    public void placeResolved(MyPlace myPlace) {
        listener.locationFound(myPlace);
    }

    @Override
    public void error(Exception e) {
        listener.locationError(e);
    }
}
