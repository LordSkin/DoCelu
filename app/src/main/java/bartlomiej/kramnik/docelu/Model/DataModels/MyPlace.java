package bartlomiej.kramnik.docelu.Model.DataModels;

import com.google.android.gms.location.places.Place;

/**
 * Data model for place used by dataBase
 */

public class MyPlace {

    private int Id;
    private String description;

    public MyPlace(int id, String description) {
        Id = id;
        this.description = description;
    }

    public MyPlace(Place place) {
    }

    public int getId() {
        return Id;
    }

    public String getDescription() {
        return description;
    }
}
