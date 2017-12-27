package bartlomiej.kramnik.docelu.Search.View;

import android.content.Context;

import com.google.android.gms.location.places.Place;

import java.util.List;

/**
 * Search Presenter Interface
 */

public interface SearchView {

    public void showError(Error e);

    public void loadList(List<Place> places);

    public void showFrom(String s);

    public void showWhere(String s);

    public Context getContext();


}
