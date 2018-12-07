package es.ulpgc.eite.cleancode.catalog.product;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;

public class ProductDetailModel implements ProductDetailContract.Model {

  public static String TAG = ProductDetailModel.class.getSimpleName();

  private WeakReference<ProductDetailActivity> activity;

  public ProductDetailModel(WeakReference<ProductDetailActivity> activity) {
    this.activity = activity;
  }

  @Override
  public CatalogItem fetchProductDetailData() {
    // Log.e(TAG, "fetchProductDetailData()");
    return null;
  }
}
