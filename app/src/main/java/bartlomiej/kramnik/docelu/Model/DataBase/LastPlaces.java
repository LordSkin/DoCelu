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
    public static int MAX_SIZE=30;

    public LastPlaces(Context c) {
        dataBaseConnector = new DataBaseConnectorImpl(c);
        placesList = dataBaseConnector.getPlaces();
    }

    public void add(MyPlace myPlace) {
        if (myPlace==null) return;

        MyPlace place = new MyPlace(myPlace.getDescription(), myPlace.getPlaceID());
        boolean isNew=true;

        for (MyPlace temp : placesList){
            if (temp.getPlaceID().equals(place.getPlaceID())){
                isNew= false;
                break;
            }
        }
        if (isNew){
            placesList.add(place);
            dataBaseConnector.addPlace(place);
            if(placesList.size()>MAX_SIZE){
                placesList.remove(0);
                dataBaseConnector.deletePlace(0);
            }
        }

    }

    public List<MyPlace> getPlacesList(){
        List<MyPlace> temp = new ArrayList<>();
        temp.addAll(placesList);
        return temp;
    }

    public MyPlace get(int i){
        if(i>=placesList.size()||i<0) return null;
        return placesList.get(i);
    }

    public void clear(){
        dataBaseConnector.clearPlaces();
        placesList.clear();
    }
}
