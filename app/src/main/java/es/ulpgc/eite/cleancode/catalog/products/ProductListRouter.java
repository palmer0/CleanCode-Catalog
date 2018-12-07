package es.ulpgc.eite.cleancode.catalog.products;

import android.content.Intent;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.AppMediator;
import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;
import es.ulpgc.eite.cleancode.catalog.product.ProductDetailActivity;


public class ProductListRouter {

  public static String TAG = ProductListRouter.class.getSimpleName();

  public WeakReference<ProductListActivity> activity;


  public void navigateToProductDetailScreen() {
    Intent intent = new Intent(activity.get(), ProductDetailActivity.class);
    activity.get().startActivity(intent);
  }

  public void passDataToProductDetailScreen(CatalogItem item) {
    AppMediator mediator = (AppMediator) activity.get().getApplication();
    mediator.setProduct(item);
  }

  public CatalogItem getDataFromCategoryListScreen() {
    AppMediator mediator = (AppMediator) activity.get().getApplication();
    CatalogItem category = mediator.getCategory();
    return category;
  }

  /*
  public String getDataFromCategoryListScreen() {
    AppMediator mediator = (AppMediator) activity.get().getApplication();
    String categoryId = mediator.getCategoryId();
    return categoryId;
  }
  */
}
