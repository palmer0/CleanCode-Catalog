package es.ulpgc.eite.cleancode.catalog.categories;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;


public class CategoryListRouter implements CategoryListContract.Router {

  public static String TAG = CategoryListRouter.class.getSimpleName();

  private CatalogMediator mediator;



  public CategoryListRouter(CatalogMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToProductListScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ProductListActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToProductListScreen(CategoryItem item) {
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
