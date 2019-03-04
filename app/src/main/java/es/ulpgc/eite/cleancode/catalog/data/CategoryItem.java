package es.ulpgc.eite.cleancode.catalog.data;


import java.util.ArrayList;
import java.util.List;


public class CategoryItem extends CatalogItem {

  public final List<ProductItem> items;


  public CategoryItem(int id, String content) {
    super(id, content);
    items = new ArrayList<>();
  }

  @Override
  public String toString() {
    return super.toString();
  }
}