package es.ulpgc.eite.cleancode.catalog.products;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;


public class ProductListPresenter implements ProductListContract.Presenter {

  public static String TAG = ProductListPresenter.class.getSimpleName();

  private WeakReference<ProductListContract.View> view;
  private ProductListState state;
  private ProductListContract.Model model;
  private ProductListContract.Router router;

  public ProductListPresenter(ProductListState state) {
    this.state = state;
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
    CategoryItem category = router.getDataFromCategoryListScreen();

    if (category != null) {
      state.category = category;
    }

    // call the model
    state.products = model.fetchProductListData(state.category);

    view.get().displayProductListData(state);

  }


  @Override
  public void selectProductListData(ProductItem item) {
    router.passDataToProductDetailScreen(item);
    router.navigateToProductDetailScreen();
  }


}
