package bartlomiej.kramnik.docelu.Search.Presenter;

import com.google.android.gms.location.places.Place;

/**
 * Search activity presenter
 */

public interface SearchPresenter {
    public void selectPlace(Place place);
    public void selectFromList(int id);
    public void search();
}
