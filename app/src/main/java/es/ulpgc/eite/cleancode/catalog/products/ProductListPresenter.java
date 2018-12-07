package es.ulpgc.eite.cleancode.catalog.products;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;


public class ProductListPresenter implements ProductListContract.Presenter {

  public static String TAG = ProductListPresenter.class.getSimpleName();

  public WeakReference<ProductListContract.View> view;
  public ProductListViewModel viewModel;
  public ProductListContract.Model model;
  public ProductListRouter router;

  @Override
  public void fetchProductListData() {
    // Log.e(TAG, "fetchProductListData()");


    // set passed state
    CatalogItem item = router.getDataFromCategoryListScreen();
    if (item != null) {
      viewModel.category = item;
    }

    /*
    String itemId = router.getDataFromCategoryListScreen();
    if (itemId != null) {
        viewModel.id = itemId;
        viewModel.item = model.fetchProductListData(itemId);
    }
    */

    // call the model
    viewModel.products = model.fetchProductListData(viewModel.category);

    view.get().displayProductListData(viewModel);

  }

  @Override
  public void selectProductListData(CatalogItem item) {
    router.passDataToProductDetailScreen(item);
    router.navigateToProductDetailScreen();
  }


}
