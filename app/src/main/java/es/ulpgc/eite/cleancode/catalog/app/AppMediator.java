package es.ulpgc.eite.cleancode.catalog.app;

import android.app.Application;

import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;

public class AppMediator extends Application {

  private CatalogItem category;
  private CatalogItem product;

  public CatalogItem getProduct() {
    CatalogItem item = product;
    //product = null;
    return item;
  }


  public void setProduct(CatalogItem item) {
    product = item;
  }

  public void setCategory(CatalogItem item) {
    category = item;
  }

  public CatalogItem getCategory() {
    CatalogItem item = category;
    //category = null;
    return item;
  }

}
