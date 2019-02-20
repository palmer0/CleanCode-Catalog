package es.ulpgc.eite.cleancode.catalog.categories;

import android.util.Log;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.data.RepositoryContract;

public class CategoryListModel implements CategoryListContract.Model {

  public static String TAG = CategoryListModel.class.getSimpleName();

  //private WeakReference<CategoryListActivity> activity;
  //private WeakReference<FragmentActivity> context;

  //private CatalogRepository repository;
  private RepositoryContract repository;

  /*
  public CategoryListModel(WeakReference<CategoryListActivity> activity) {
    this.activity = activity;
    repository = CatalogRepository.getInstance();
  }
  */

//  public CategoryListModel(WeakReference<FragmentActivity> context) {
//    this.context = context;
//    repository = CatalogRepository.getInstance();
//
//  }

  public CategoryListModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public List<CategoryItem> fetchCategoryListData() {
    Log.e(TAG, "fetchCategoryListData()");
    return repository.getCategoryList();
  }
}
