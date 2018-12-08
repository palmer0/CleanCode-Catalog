package es.ulpgc.eite.cleancode.catalog.categories;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;

interface CategoryListContract {

  interface View {
    void displayCategoryListData(CategoryListViewModel viewModel);
  }

  interface Presenter {
    void fetchCategoryListData();
    void selectCategoryListData(CategoryItem item);
  }

  interface Model {
    List<CategoryItem> fetchCategoryListData();
  }
}