package es.ulpgc.eite.cleancode.catalog.data;


public abstract class CatalogItem {
  public final int id;
  public final String content;
  //public final String details;
  //public final List<CatalogItem> items;

  public CatalogItem(int id, String content) {
    this.id = id;
    this.content = content;
  }

  /*
  public CatalogItem(int id, String content, String details) {
    this.id = id;
    this.content = content;
    this.details = details;
    //items = new ArrayList<>();
  }
  */

  @Override
  public String toString() {
    return content;
  }
}