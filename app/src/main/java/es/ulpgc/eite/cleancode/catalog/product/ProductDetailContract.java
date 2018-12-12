package es.ulpgc.eite.cleancode.catalog.product;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.data.ProductItem;

interface ProductDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayProductDetailData(ProductDetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);

    void fetchProductDetailData();
  }

  interface Model {
    //ProductItem fetchProductDetailData();
  }

  interface Router {

    void navigateToNextScreen();
    void passDataToNextScreen(String data);
    ProductItem getDataFromProductListScreen();
  }
}