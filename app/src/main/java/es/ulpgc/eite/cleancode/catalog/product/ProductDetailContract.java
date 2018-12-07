package es.ulpgc.eite.cleancode.catalog.product;

import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;

interface ProductDetailContract {

  interface View {
    void displayProductDetailData(ProductDetailViewModel viewModel);
  }

  interface Presenter {
    void fetchProductDetailData();
  }

  interface Model {
    CatalogItem fetchProductDetailData();
  }
}