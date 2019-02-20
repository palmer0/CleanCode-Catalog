package es.ulpgc.eite.cleancode.catalog.categories;

import android.util.Log;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.CatalogRepository;
import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;

public class CategoryListModel implements CategoryListContract.Model {

  public static String TAG = CategoryListModel.class.getSimpleName();

  //private WeakReference<CategoryListActivity> activity;
  private CatalogRepository repository;

  public CategoryListModel(CatalogRepository repository) {
    this.repository = repository;

  }

  public CategoryListModel() {
    this.repository = CatalogRepository.getInstance();

  }

//  public CategoryListModel(WeakReference<FragmentActivity> context) {
//    this.context = context;
//    repository = CatalogRepository.getInstance();
//
//  }

  @Override
  public List<CategoryItem> fetchCategoryListData() {
    Log.e(TAG, "fetchCategoryListData()");
    return repository.getCategoryList();
  }
}
