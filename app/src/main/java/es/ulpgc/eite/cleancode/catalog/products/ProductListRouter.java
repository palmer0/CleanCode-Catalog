package es.ulpgc.eite.cleancode.catalog.products;

import android.content.Intent;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;
import es.ulpgc.eite.cleancode.catalog.product.ProductDetailActivity;


public class ProductListRouter {

  public static String TAG = ProductListRouter.class.getSimpleName();

  public WeakReference<ProductListActivity> activity;


  public void navigateToProductDetailScreen() {
    Intent intent = new Intent(activity.get(), ProductDetailActivity.class);
    activity.get().startActivity(intent);
  }

  /*
  public void passDataToProductDetailScreen(CatalogItem item) {
    CatalogMediator mediator = (CatalogMediator) activity.get().getApplication();
    mediator.setProduct(item);
  }
  */


  public void passDataToProductDetailScreen(ProductItem item) {
    CatalogMediator mediator = (CatalogMediator) activity.get().getApplication();
    mediator.setProduct(item);
  }

  /*
  public CatalogItem getDataFromCategoryListScreen() {
    CatalogMediator mediator = (CatalogMediator) activity.get().getApplication();
    CatalogItem category = mediator.getCategory();
    return category;
  }
  */

  public CategoryItem getDataFromCategoryListScreen() {
    CatalogMediator mediator = (CatalogMediator) activity.get().getApplication();
    CategoryItem category = mediator.getCategory();
    return category;
  }

}
