package bartlomiej.kramnik.docelu.Presenter.Search;

import android.content.Context;

import com.google.android.gms.location.places.Place;

import java.util.List;

/**
 * Search Presenter Interface
 */

public interface SearchActivity {

    public void showError(Error e);

    public void loadList(List<Place> places);

    public void showFrom(String s);

    public void showWhere(String s);

    public Context getContext();


}
