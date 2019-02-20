package es.ulpgc.eite.cleancode.catalog.product;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;


public class ProductDetailScreen {

  public static void configure(ProductDetailContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    /*
    ProductDetailViewModel viewModel =
        ViewModelProviders.of(context.get()).get(ProductDetailViewModel.class);
    */

    ProductDetailContract.Router router = new ProductDetailRouter(context);
    /*
    ProductDetailContract.Presenter presenter =
        new ProductDetailPresenter(viewModel, router);
    */
    ProductDetailContract.Presenter presenter=new ProductDetailPresenter(context);
    ProductDetailModel model = new ProductDetailModel(context);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }

  /*
  public static void configure(ProductDetailActivity activity) {

    ProductDetailRouter router = new ProductDetailRouter();
    router.activity = new WeakReference<>(activity);

    ProductDetailPresenter presenter = new ProductDetailPresenter();
    presenter.viewModel =
        ViewModelProviders.of(activity).get(ProductDetailViewModel.class);
    presenter.view = new WeakReference<ProductDetailContract.View>(activity);
    presenter.router = router;

    ProductDetailModel model =
        new ProductDetailModel(new WeakReference<>(activity));
    presenter.model = model;

    if (activity.presenter == null) {
      activity.presenter = presenter;
    }

  }
  */

}
