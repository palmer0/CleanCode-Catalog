package es.ulpgc.eite.cleancode.catalog.app;

import android.app.Application;

import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;

public class CatalogMediator extends Application {

  private CategoryItem category;
  private ProductItem product;
  //private CatalogItem category;
  //private CatalogItem product;

  public ProductItem getProduct() {
    ProductItem item = product;
    //product = null;
    return item;
  }


  public void setProduct(ProductItem item) {
    product = item;
  }

  public void setCategory(CategoryItem item) {
    category = item;
  }

  public CategoryItem getCategory() {
    CategoryItem item = category;
    //category = null;
    return item;
  }

  /*
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
  */

}
