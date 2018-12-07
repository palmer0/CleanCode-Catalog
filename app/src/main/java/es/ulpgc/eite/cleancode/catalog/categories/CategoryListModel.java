package es.ulpgc.eite.cleancode.catalog.categories;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;
import es.ulpgc.eite.cleancode.catalog.data.CatalogRepository;

public class CategoryListModel implements CategoryListContract.Model {

  public static String TAG = CategoryListModel.class.getSimpleName();

  private WeakReference<CategoryListActivity> activity;
  private CatalogRepository repository;


  public CategoryListModel(WeakReference<CategoryListActivity> activity) {
    this.activity = activity;
    //repository = new CatalogRepository();
    repository = CatalogRepository.getInstance();
  }

  @Override
  public List<CatalogItem> fetchCategoryListData() {
    Log.e(TAG, "fetchCategoryListData()");
    //return repository.getItemList();
    return repository.getCategoryList();
    //return CatalogRepository.getInstance().getCategoryList();
  }
}
