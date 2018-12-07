package es.ulpgc.eite.cleancode.catalog.data;

import java.util.ArrayList;
import java.util.List;


public class CatalogRepository {

  private static CatalogRepository INSTANCE;

  public static CatalogRepository getInstance() {
    if(INSTANCE == null){
      INSTANCE = new CatalogRepository();
    }

    return INSTANCE;
  }



  private final List<CatalogItem> itemList = new ArrayList<>();
  private final int COUNT = 20;

  private CatalogRepository() {
    // Add some sample items.
    for (int index = 1; index <= COUNT; index++) {
      addCategory(createCategory(index));
    }
  }


  public List<CatalogItem> getProductList(int id) {
    for (int index = 1; index <= COUNT; index++) {
      CatalogItem item = itemList.get(index);

      if(item.id == id) {
        return item.items;
      }
    }

    return new ArrayList<>();
  }


  public List<CatalogItem> getCategoryList() {
    return itemList;
  }


  private void addCategory(CatalogItem item) {
    itemList.add(item);
  }

  private void addProduct(List<CatalogItem> itemList, CatalogItem item) {
    itemList.add(item);
  }


  private CatalogItem createProduct(int id, int position) {
    String content = "Product " + id + "." + position;

    return new CatalogItem(
        position, content, fetchProductDetails(id, position)
    );
  }

  private CatalogItem createCategory(int position) {
    CatalogItem item = new CatalogItem(
        position, "Category " + position, fetchCategoryDetails(position)
    );

    for (int index = 1; index <= COUNT; index++) {
      addProduct(item.items, createProduct(item.id, index));
    }

    return item;
  }


  private String fetchCategoryDetails(int position) {
    StringBuilder builder = new StringBuilder();
    builder.append("Details about Category: ").append(position);

    for (int index = 0; index < position; index++) {
      builder.append("\nMore details information here.");
    }

    return builder.toString();
  }

  private String fetchProductDetails(int id, int position) {
    String content = "Details about Product:  " + id + "." + position;
    StringBuilder builder = new StringBuilder();
    builder.append(content);

    for (int index = 0; index < position; index++) {
      builder.append("\nMore details information here.");
    }

    return builder.toString();
  }

}
