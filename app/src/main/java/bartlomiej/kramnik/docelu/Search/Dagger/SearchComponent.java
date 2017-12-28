package bartlomiej.kramnik.docelu.Search.Dagger;

import bartlomiej.kramnik.docelu.Search.Presenter.SearchPresenterImpl;
import bartlomiej.kramnik.docelu.Search.View.SearchActivityImpl;
import dagger.Component;
import dagger.Provides;

/**
 * Created by adolf on 27.12.17.
 */

@Component(modules = SearchPresenterModule.class)
public interface SearchComponent {
    void inject(SearchPresenterImpl presenter);
}
