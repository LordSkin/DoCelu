package bartlomiej.kramnik.docelu.Model.DataBase;

import java.util.List;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;

/**
 * Interface for dataBase
 */

public interface DataBaseConnector {
    public List<MyPlace> getPlaces();

    public MyPlace getPlace(int i);

    public void addPlace(MyPlace p);

    public void clearPlaces();

    public void deletePlace(MyPlace p);

    public void deletePlace(int i);
}
