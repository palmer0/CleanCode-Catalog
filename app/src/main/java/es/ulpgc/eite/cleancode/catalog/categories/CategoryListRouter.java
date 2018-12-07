package es.ulpgc.eite.cleancode.catalog.categories;

import android.content.Intent;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.AppMediator;
import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;


public class CategoryListRouter {

  public static String TAG = CategoryListRouter.class.getSimpleName();

  public WeakReference<CategoryListActivity> activity;


  public void navigateToProductListScreen() {
    Intent intent = new Intent(activity.get(), ProductListActivity.class);
    activity.get().startActivity(intent);
  }


  public void passDataToProductListScreen(CatalogItem item) {
    AppMediator mediator = (AppMediator) activity.get().getApplication();
    mediator.setCategory(item);
  }


  public String getDataFromPreviousScreen() {
    //AppMediator mediator = (AppMediator) activity.get().getApplication();
    //String data = mediator.getData();
    //mediator.resetData();
    //return data;
    return null;
  }
}
