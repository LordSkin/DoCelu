package bartlomiej.kramnik.docelu.Model.DataBase;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;

/**
 * Class providing access to last places, connecting to database
 */

public class LastPlaces {

    private List<MyPlace> placesList;
    private DataBaseConnector dataBaseConnector;

    public LastPlaces(Context c) {
        dataBaseConnector = new DataBaseConnectorImpl(c);
        placesList = dataBaseConnector.getPlaces();
    }

    public void add(MyPlace myPlace) {
        placesList.remove(0);
        MyPlace place = new MyPlace(placesList.get(placesList.size()-1).getId()+1, myPlace.getDescription(), myPlace.getPlaceID());
        placesList.add(place);
        dataBaseConnector.addPlace(place);
        dataBaseConnector.deletePlace(0);
    }

    public List<MyPlace> getPlacesList(){
        List<MyPlace> temp = new ArrayList<>();
        temp.addAll(placesList);
        return temp;
    }

    public MyPlace get(int i){
        return placesList.get(i);
    }
}
