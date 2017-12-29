package bartlomiej.kramnik.docelu.Model.DataModels;

import com.google.android.gms.location.places.Place;

/**
 * Data model for place used by dataBase
 */

public class MyPlace {

    private String description;
    private String placeID;

    public MyPlace(String description, String placeID) {
        this.placeID = placeID;
        this.description = description;
    }

    public MyPlace(Place place) {
        ///TODO
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
        if (getDescription() != null ? !getDescription().equals(myPlace.getDescription()) : myPlace.getDescription() != null)
            return false;
        return getPlaceID().equals(myPlace.getPlaceID());
    }

}
