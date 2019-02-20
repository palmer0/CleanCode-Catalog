package es.ulpgc.eite.cleancode.catalog.products;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.data.CatalogRepository;
import es.ulpgc.eite.cleancode.catalog.data.RepositoryContract;

public class ProductListScreen {

  public static void configure(ProductListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    CatalogMediator mediator = (CatalogMediator) context.get().getApplication();
    ProductListState state = mediator.getProductListState();
    RepositoryContract repository = CatalogRepository.getInstance();

    /*
    ProductListViewModel viewModel =
        ViewModelProviders.of(context.get()).get(ProductListViewModel.class);
    */

    ProductListContract.Router router = new ProductListRouter(mediator);
    /*
    ProductListContract.Presenter presenter =
        new ProductListPresenter(viewModel, router);
    */
    ProductListContract.Presenter presenter = new ProductListPresenter(state);
    ProductListModel model = new ProductListModel(repository);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }


  /*
  public static void configure(ProductListActivity activity) {

    ProductListRouter router = new ProductListRouter();
    router.activity = new WeakReference<>(activity);

    ProductListPresenter presenter = new ProductListPresenter();
    presenter.viewModel =
        ViewModelProviders.of(activity).get(ProductListViewModel.class);
    presenter.view = new WeakReference<ProductListContract.View>(activity);
    presenter.router = router;

    ProductListModel model = new ProductListModel(new WeakReference<>(activity));
    presenter.model = model;

    if (activity.presenter == null) {
      activity.presenter = presenter;
    }

  }
  */
  
}
