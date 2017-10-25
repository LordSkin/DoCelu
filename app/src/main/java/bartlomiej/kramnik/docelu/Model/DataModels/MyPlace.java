package bartlomiej.kramnik.docelu.Model.DataModels;

import com.google.android.gms.location.places.Place;

/**
 * Data model for place used by dataBase
 */

public class MyPlace {

    private int Id;
    private String description;
    private String placeID;

    public MyPlace(int id, String description, String placeID) {
        Id = id;
        this.placeID = placeID;
        this.description = description;
    }

    public MyPlace(Place place) {

    }

    public MyPlace(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public String getDescription() {
        return description;
    }

    public String getPlaceID() {
        return placeID;
    }
}
