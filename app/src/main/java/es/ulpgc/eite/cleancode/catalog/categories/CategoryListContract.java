package es.ulpgc.eite.cleancode.catalog.categories;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;

interface CategoryListContract {

  interface View {
    void displayCategoryListData(CategoryListViewModel viewModel);
  }

  interface Presenter {
    void fetchCategoryListData();
    void selectCategoryListData(CatalogItem item);
    //void selectCategoryListData(String id);
  }

  interface Model {
    List<CatalogItem> fetchCategoryListData();
  }
}