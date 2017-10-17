package bartlomiej.kramnik.docelu.Model.DataBase;

import java.util.List;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;

/**
 * Created by Admin on 17.10.2017.
 */

public interface DataBaseConnector {
    public List<MyPlace> getPlaces();

    public MyPlace getPlace(int i);

    public void addPlace(MyPlace p);

    public void clarPlaces();
}
