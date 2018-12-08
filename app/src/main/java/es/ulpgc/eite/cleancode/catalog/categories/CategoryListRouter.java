package es.ulpgc.eite.cleancode.catalog.categories;

import android.content.Intent;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;


public class CategoryListRouter {

  public static String TAG = CategoryListRouter.class.getSimpleName();

  public WeakReference<CategoryListActivity> activity;


  public void navigateToProductListScreen() {
    Intent intent = new Intent(activity.get(), ProductListActivity.class);
    activity.get().startActivity(intent);
  }

  public void passDataToProductListScreen(CategoryItem item) {
    CatalogMediator mediator = (CatalogMediator) activity.get().getApplication();
    mediator.setCategory(item);
  }


  public String getDataFromPreviousScreen() {
    //CatalogMediator mediator = (CatalogMediator) activity.get().getApplication();
    //String data = mediator.getData();
    //mediator.resetData();
    //return data;
    return null;
  }
}
