package es.ulpgc.eite.cleancode.catalog.categories;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;


public class CategoryListRouter implements CategoryListContract.Router {

  public static String TAG = CategoryListRouter.class.getSimpleName();

  //public WeakReference<CategoryListActivity> activity;
  private WeakReference<FragmentActivity> context;

  public CategoryListRouter(WeakReference<FragmentActivity> context) {
    this.context = context;
  }

  @Override
  public void navigateToProductListScreen() {
    Intent intent = new Intent(context.get(), ProductListActivity.class);
    context.get().startActivity(intent);
  }

  @Override
  public void passDataToProductListScreen(CategoryItem item) {
    CatalogMediator mediator = (CatalogMediator) context.get().getApplication();
    mediator.setCategory(item);
  }

  @Override
  public String getDataFromPreviousScreen() {
    //CatalogMediator mediator = (CatalogMediator) context.get().getApplication();
    //String data = mediator.getData();
    //mediator.resetData();
    //return data;
    return null;
  }
}
