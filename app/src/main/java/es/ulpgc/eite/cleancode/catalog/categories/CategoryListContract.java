package es.ulpgc.eite.cleancode.catalog.categories;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;

interface CategoryListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayCategoryListData(CategoryListViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void injectRouter(Router router);

    void fetchCategoryListData();
    void selectCategoryListData(CategoryItem item);
  }

  interface Model {
    List<CategoryItem> fetchCategoryListData();
  }

  interface Router {

    void navigateToProductListScreen();
    void passDataToProductListScreen(CategoryItem item);
  }
}