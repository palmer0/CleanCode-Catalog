package es.ulpgc.eite.cleancode.catalog.product;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;


public class ProductDetailRouter implements ProductDetailContract.Router {

  public static String TAG = ProductDetailRouter.class.getSimpleName();

  private CatalogMediator mediator;

  public ProductDetailRouter(CatalogMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public ProductItem getDataFromProductListScreen() {
    ProductItem product = mediator.getProduct();
    return product;
  }
}
