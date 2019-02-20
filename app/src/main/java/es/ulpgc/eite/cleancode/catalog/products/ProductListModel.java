package es.ulpgc.eite.cleancode.catalog.products;

import android.util.Log;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;
import es.ulpgc.eite.cleancode.catalog.data.RepositoryContract;

public class ProductListModel implements ProductListContract.Model {

  public static String TAG = ProductListModel.class.getSimpleName();

  //private WeakReference<ProductListActivity> activity;
  //private WeakReference<FragmentActivity> context;

  //private CatalogRepository repository;
  private RepositoryContract repository;

  public ProductListModel(RepositoryContract repository) {
    this.repository = repository;
  }

  /*
  public ProductListModel(WeakReference<ProductListActivity> activity) {
    this.activity = activity;
    repository = CatalogRepository.getInstance();
  }
  */

//  public ProductListModel(WeakReference<FragmentActivity> context) {
//    this.context = context;
//    repository = CatalogRepository.getInstance();
//  }


  @Override
  public List<ProductItem> fetchProductListData(CategoryItem category) {
    Log.e(TAG, "fetchProductListData()");
    return repository.getProductList(category.id);
  }
}
