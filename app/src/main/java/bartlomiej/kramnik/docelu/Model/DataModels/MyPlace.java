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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyPlace)) return false;

        MyPlace myPlace = (MyPlace) o;

        if (getId() != myPlace.getId()) return false;
        if (getDescription() != null ? !getDescription().equals(myPlace.getDescription()) : myPlace.getDescription() != null)
            return false;
        return getPlaceID().equals(myPlace.getPlaceID());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + getPlaceID().hashCode();
        return result;
    }
}
