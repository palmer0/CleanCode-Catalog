package es.ulpgc.eite.cleancode.catalog.categories;

import android.util.Log;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.data.RepositoryContract;

public class CategoryListModel implements CategoryListContract.Model {

  public static String TAG = CategoryListModel.class.getSimpleName();

  private RepositoryContract repository;


  public CategoryListModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public List<CategoryItem> fetchCategoryListData() {
    Log.e(TAG, "fetchCategoryListData()");
    return repository.getCategoryList();
  }
}
