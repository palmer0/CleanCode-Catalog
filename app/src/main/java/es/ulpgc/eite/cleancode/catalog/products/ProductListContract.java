package es.ulpgc.eite.cleancode.catalog.products;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;

interface ProductListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void navigateToProductDetailScreen();

    void displayProductListData(ProductListViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    //void injectRouter(Router router);

    void fetchProductListData();
    void selectProductListData(ProductItem item);
  }

  interface Model {
    List<ProductItem> fetchProductListData(CategoryItem category);
  }

//  interface Router {
//
//    void navigateToProductDetailScreen();
//    void passDataToProductDetailScreen(ProductItem item);
//    CategoryItem getDataFromCategoryListScreen();
//  }
}