package es.ulpgc.eite.cleancode.catalog.data;


import java.util.ArrayList;
import java.util.List;


public class CategoryItem extends CatalogItem {

  public final String details;
  public final List<ProductItem> items;

  public CategoryItem(int id, String content, String details) {
    super(id, content);
    this.details = details;
    items = new ArrayList<>();
  }

  @Override
  public String toString() {
    return super.toString();
  }
}