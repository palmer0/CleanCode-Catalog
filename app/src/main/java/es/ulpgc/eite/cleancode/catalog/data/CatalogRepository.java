package es.ulpgc.eite.cleancode.catalog.data;

import java.util.ArrayList;
import java.util.List;


public class CatalogRepository {

  private static CatalogRepository INSTANCE;

  private final List<CategoryItem> itemList = new ArrayList<>();
  private final int COUNT = 20;

  public static CatalogRepository getInstance() {
    if(INSTANCE == null){
      INSTANCE = new CatalogRepository();
    }

    return INSTANCE;
  }

  private CatalogRepository() {
    // Add some sample items.
    for (int index = 1; index <= COUNT; index++) {
      addCategory(createCategory(index));
    }
  }


  public List<ProductItem> getProductList(int id) {
    for (int index = 1; index <= COUNT; index++) {
      CategoryItem item = itemList.get(index);

      if(item.id == id) {
        return item.items;
      }
    }

    return new ArrayList<>();
  }


  public List<CategoryItem> getCategoryList() {
    return itemList;
  }


  private void addCategory(CategoryItem item) {
    itemList.add(item);
  }


  private void addProduct(List<ProductItem> itemList, ProductItem item) {
    itemList.add(item);
  }



  private ProductItem createProduct(int id, int position) {
    String content = "Product " + id + "." + position;

    return new ProductItem(
        position, content, fetchProductDetails(id, position)
    );

  }


  private CategoryItem createCategory(int position) {

    CategoryItem item = new CategoryItem(
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
