package es.ulpgc.eite.cleancode.catalog.product;

interface ProductDetailContract {

  interface View {
    void displayProductDetailData(ProductDetailViewModel viewModel);
  }

  interface Presenter {
    void fetchProductDetailData();
  }

  interface Model {
    //ProductItem fetchProductDetailData();
  }
}