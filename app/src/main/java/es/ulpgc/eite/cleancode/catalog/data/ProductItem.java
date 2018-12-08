package es.ulpgc.eite.cleancode.catalog.data;


public class ProductItem extends CatalogItem {

  public final String details;

  public ProductItem(int id, String content, String details) {
    super(id, content);
    this.details = details;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}