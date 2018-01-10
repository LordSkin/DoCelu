package bartlomiej.kramnik.docelu.Search.Dagger;

import bartlomiej.kramnik.docelu.Search.Presenter.SearchPresenterImpl;
import bartlomiej.kramnik.docelu.Search.View.ListAdapter;
import bartlomiej.kramnik.docelu.Search.View.SearchActivityImpl;
import dagger.Component;
import dagger.Provides;

/**
 * Component required by dagger for PlaceSearch
 */

@Component(modules = {SearchPresenterModule.class, SearchAdapterModule.class})
public interface SearchComponent {
    void inject(SearchPresenterImpl presenter);
    void inject(ListAdapter adapter);
}
