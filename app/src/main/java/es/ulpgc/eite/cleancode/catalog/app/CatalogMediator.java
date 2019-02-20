package es.ulpgc.eite.cleancode.catalog.app;

import android.app.Application;

import es.ulpgc.eite.cleancode.catalog.categories.CategoryListState;
import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;

public class CatalogMediator extends Application {

  private CategoryListState categoryListState = new CategoryListState();

  private CategoryItem category;
  private ProductItem product;

  public CategoryListState getCategoryListState() {
    return categoryListState;
  }

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

}
