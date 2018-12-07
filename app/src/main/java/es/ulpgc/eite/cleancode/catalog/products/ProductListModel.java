package es.ulpgc.eite.cleancode.catalog.products;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;
import es.ulpgc.eite.cleancode.catalog.data.CatalogRepository;

public class ProductListModel implements ProductListContract.Model {

  public static String TAG = ProductListModel.class.getSimpleName();

  private WeakReference<ProductListActivity> activity;

  private CatalogRepository repository;

  public ProductListModel(WeakReference<ProductListActivity> activity) {
    this.activity = activity;
    repository = CatalogRepository.getInstance();
  }

  @Override
  public List<CatalogItem> fetchProductListData(CatalogItem category) {
    Log.e(TAG, "fetchProductListData()");
    return repository.getProductList(category.id);
  }

}
