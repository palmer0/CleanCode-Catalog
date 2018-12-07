package es.ulpgc.eite.cleancode.catalog.products;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;

interface ProductListContract {

  interface View {
    void displayProductListData(ProductListViewModel viewModel);
  }

  interface Presenter {
    void fetchProductListData();
    void selectProductListData(CatalogItem item);
  }

  interface Model {
    List<CatalogItem> fetchProductListData(CatalogItem category);
  }
}