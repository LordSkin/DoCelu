package bartlomiej.kramnik.docelu.Model.DataBase;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;

/**
 * Queue for places, connecting to database
 */

public class LastPlaces implements Queue<MyPlace> {

    private List<MyPlace> placesList;
    DataBaseConnector dataBaseConnector;

    public LastPlaces(Context c) {
        dataBaseConnector = new DataBaseConnectorImpl(c);
        placesList = dataBaseConnector.getPlaces();
    }

    @Override
    public int size() {
       return placesList.size();
    }

    @Override
    public boolean isEmpty() {
        return placesList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return placesList.contains((MyPlace)o);
    }

    @NonNull
    @Override
    public Iterator<MyPlace> iterator() {
        return placesList.iterator();
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return placesList.toArray();
    }

    @NonNull
    @Override
    public <T> T[] toArray(@NonNull T[] ts) {
        return (T[]) placesList.toArray();
    }

    @Override
    public boolean add(MyPlace myPlace) {
        placesList.remove(0);
        MyPlace place = new MyPlace(placesList.get(size()-1).getId()+1, myPlace.getDescription(), myPlace.getPlaceID());
        placesList.add(place);
        dataBaseConnector.addPlace(place);
        dataBaseConnector.deletePlace(0);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends MyPlace> collection) {
        return false;
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {
        placesList.clear();
        dataBaseConnector.clearPlaces();
    }

    @Override
    public boolean offer(MyPlace myPlace) {
        return false;
    }

    @Override
    public MyPlace remove() {
        return null;
    }

    @Override
    public MyPlace poll() {
        return null;
    }

    @Override
    public MyPlace element() {
        return null;
    }

    @Override
    public MyPlace peek() {
        return null;
    }
}
