package es.ulpgc.eite.cleancode.catalog.categories;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.data.CatalogRepository;
import es.ulpgc.eite.cleancode.catalog.data.RepositoryContract;

public class CategoryListScreen {

  public static void configure(CategoryListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    CatalogMediator mediator = (CatalogMediator) context.get().getApplication();
    CategoryListState state = mediator.getCategoryListState();
    RepositoryContract repository = CatalogRepository.getInstance();

    CategoryListContract.Router router = new CategoryListRouter(mediator);
    CategoryListContract.Presenter presenter=new CategoryListPresenter(state);
    CategoryListModel model = new CategoryListModel(repository);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }

}
