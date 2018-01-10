package bartlomiej.kramnik.docelu.Search.Presenter;

import com.google.android.gms.location.places.Place;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;

/**
 * Search activity presenter
 */

public interface SearchPresenter {
    public void selectPlace(Place place);

    public void selectFromList(int id);

    public void fromSelected();

    public void whereSelected();

    public void search();

    public MyPlace getLastPlace(int id);

    public int getlastPlacesCount();

    public void useLocation();

    public void permissionResponse(int requestCode, String permissions[], int[] grantResults);
}
