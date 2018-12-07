package es.ulpgc.eite.cleancode.catalog.product;

import android.content.Intent;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.AppMediator;
import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;


public class ProductDetailRouter {

  public static String TAG = ProductDetailRouter.class.getSimpleName();

  public WeakReference<ProductDetailActivity> activity;


  public void navigateToNextScreen() {
    Intent intent = new Intent(activity.get(), ProductDetailActivity.class);
    activity.get().startActivity(intent);
  }

  public void passDataToNextScreen(String data) {
    //AppMediator mediator = (AppMediator) activity.get().getApplication();
    //mediator.setData(data);
  }

  public CatalogItem getDataFromProductListScreen() {
    AppMediator mediator = (AppMediator) activity.get().getApplication();
    CatalogItem product = mediator.getProduct();
    return product;
  }
}
