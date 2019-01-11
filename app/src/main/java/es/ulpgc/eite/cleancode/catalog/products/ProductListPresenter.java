package es.ulpgc.eite.cleancode.catalog.products;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;


public class ProductListPresenter implements ProductListContract.Presenter {

  public static String TAG = ProductListPresenter.class.getSimpleName();

  /*
  public WeakReference<ProductListContract.View> view;
  public ProductListViewModel viewModel;
  public ProductListContract.Model model;
  public ProductListRouter router;
  */

  private WeakReference<ProductListContract.View> view;
  private ProductListViewModel viewModel;
  private ProductListContract.Model model;
  private ProductListContract.Router router;

  /*
  public ProductListPresenter(
      ProductListViewModel viewModel, ProductListContract.Router router) {

    this.viewModel = viewModel;
    this.router = router;
  }
  */

  public ProductListPresenter(WeakReference<FragmentActivity> context) {
    viewModel = ViewModelProviders
        .of(context.get())
        .get(ProductListViewModel.class);
  }

  @Override
  public void injectView(WeakReference<ProductListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ProductListContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ProductListContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchProductListData() {
    // Log.e(TAG, "fetchProductListData()");

    // set passed state
    CategoryItem item = router.getDataFromCategoryListScreen();

    if (item != null) {
      viewModel.category = item;
    }

    // call the model
    viewModel.products = model.fetchProductListData(viewModel.category);

    view.get().displayProductListData(viewModel);

  }


  @Override
  public void selectProductListData(ProductItem item) {
    router.passDataToProductDetailScreen(item);
    router.navigateToProductDetailScreen();
  }


}
