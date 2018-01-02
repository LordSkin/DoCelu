package bartlomiej.kramnik.docelu.Search.Dagger;

import bartlomiej.kramnik.docelu.Search.Presenter.SearchPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Module for injecting to List adapter
 */

@Module
public class SearchAdapterModule {
    private SearchPresenter presenter;



    public SearchAdapterModule(SearchPresenter presenter) {
        this.presenter = presenter;
    }

    @Provides
    public SearchPresenter presenterProvider(){
        return presenter;
    }
}
