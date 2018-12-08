package es.ulpgc.eite.cleancode.catalog.products;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;

interface ProductListContract {

  interface View {
    void displayProductListData(ProductListViewModel viewModel);
  }

  interface Presenter {
    void fetchProductListData();
    void selectProductListData(ProductItem item);
  }

  interface Model {
    List<ProductItem> fetchProductListData(CategoryItem category);
  }
}