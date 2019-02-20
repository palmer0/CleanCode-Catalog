package es.ulpgc.eite.cleancode.catalog.categories;

import android.support.v4.app.FragmentActivity;

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

    /*
    CategoryListViewModel viewModel =
        ViewModelProviders.of(context.get()).get(CategoryListViewModel.class);
    */

    CategoryListContract.Router router = new CategoryListRouter(mediator);
    /*
    CategoryListContract.Presenter presenter =
        new CategoryListPresenter(viewModel, router);
    */
    CategoryListContract.Presenter presenter=new CategoryListPresenter(state);
    CategoryListModel model = new CategoryListModel(repository);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }
  
  /*
  public static void configure(CategoryListActivity activity) {

    CategoryListRouter router = new CategoryListRouter();
    router.activity = new WeakReference<>(activity);

    CategoryListPresenter presenter = new CategoryListPresenter();
    presenter.viewModel =
        ViewModelProviders.of(activity).get(CategoryListViewModel.class);
    presenter.view = new WeakReference<CategoryListContract.View>(activity);
    presenter.router = router;

    CategoryListModel model = new CategoryListModel(new WeakReference<>(activity));
    presenter.model = model;

    if (activity.presenter == null) {
      activity.presenter = presenter;
    }

  }
  */
  
}
