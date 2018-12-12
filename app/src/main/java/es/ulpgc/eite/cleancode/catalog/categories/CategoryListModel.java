package es.ulpgc.eite.cleancode.catalog.categories;

import android.support.v4.app.FragmentActivity;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.CatalogRepository;
import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;

public class CategoryListModel implements CategoryListContract.Model {

  public static String TAG = CategoryListModel.class.getSimpleName();

  //private WeakReference<CategoryListActivity> activity;
  private WeakReference<FragmentActivity> context;
  private CatalogRepository repository;

  /*
  public CategoryListModel(WeakReference<CategoryListActivity> activity) {
    this.activity = activity;
    repository = CatalogRepository.getInstance();
  }
  */

  public CategoryListModel(WeakReference<FragmentActivity> context) {
    this.context = context;
    repository = CatalogRepository.getInstance();

  }

  @Override
  public List<CategoryItem> fetchCategoryListData() {
    Log.e(TAG, "fetchCategoryListData()");
    return repository.getCategoryList();
  }
}
