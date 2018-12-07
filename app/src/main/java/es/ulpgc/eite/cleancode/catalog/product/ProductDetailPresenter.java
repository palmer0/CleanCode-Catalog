package es.ulpgc.eite.cleancode.catalog.product;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;


public class ProductDetailPresenter implements ProductDetailContract.Presenter {

  public static String TAG = ProductDetailPresenter.class.getSimpleName();

  public WeakReference<ProductDetailContract.View> view;
  public ProductDetailViewModel viewModel;
  public ProductDetailContract.Model model;
  public ProductDetailRouter router;

  @Override
  public void fetchProductDetailData() {
    // Log.e(TAG, "fetchProductDetailData()");

    // set passed state
    CatalogItem product = router.getDataFromProductListScreen();
    if(product != null) {
        viewModel.product = product;
    }

    /*
    // call the model
    CatalogItem item = model.fetchProductDetailData();
    viewModel.item = item;
    */

    view.get().displayProductDetailData(viewModel);

  }


}
