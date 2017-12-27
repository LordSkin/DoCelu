package bartlomiej.kramnik.docelu.Search.Dagger;

import bartlomiej.kramnik.docelu.Search.View.SearchView;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module for Search Presenter
 */

@Module
public class SearchPresenterModule {

    private SearchView view;

    public SearchPresenterModule(SearchView view) {
        this.view = view;
    }

    @Provides
    SearchView provideSearchView(){
        return view;
    }

}
