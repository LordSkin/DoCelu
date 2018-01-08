package bartlomiej.kramnik.docelu.Search.View;

import android.content.Context;

import com.google.android.gms.location.places.Place;

import java.util.List;

import bartlomiej.kramnik.docelu.Model.DataModels.Route;

/**
 * Search Presenter Interface
 */

public interface SearchView {


    public void showError(int e);

    public void reLoadList();

    public void showFrom(String s);

    public void showWhere(String s);

    public Context getContext();

    public void startActivity(Route route, String from, String where);

    public void showLoadingIndicator();

    public void hideLoadingIndicator();
}
