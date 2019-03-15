package es.ulpgc.eite.cleancode.catalog.products;

import android.util.Log;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;
import es.ulpgc.eite.cleancode.catalog.data.RepositoryContract;

public class ProductListModel implements ProductListContract.Model {

  public static String TAG = ProductListModel.class.getSimpleName();

  private RepositoryContract repository;

  public ProductListModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public List<ProductItem> fetchProductListData(CategoryItem category) {
    Log.e(TAG, "fetchProductListData()");
    return repository.getProductList(category.id);
  }

}
