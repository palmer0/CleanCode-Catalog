package es.ulpgc.eite.cleancode.catalog.categories;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;


public class CategoryListPresenter implements CategoryListContract.Presenter {

  public static String TAG = CategoryListPresenter.class.getSimpleName();

  /*
  public WeakReference<CategoryListContract.View> view;
  public CategoryListViewModel viewModel;
  public CategoryListContract.Model model;
  public CategoryListRouter router;
  */

  private WeakReference<CategoryListContract.View> view;
  private CategoryListViewModel viewModel;
  private CategoryListContract.Model model;
  private CategoryListContract.Router router;

  public CategoryListPresenter(
      CategoryListViewModel viewModel, CategoryListContract.Router router) {

    this.viewModel = viewModel;
    this.router = router;
  }

  @Override
  public void injectView(WeakReference<CategoryListContract.View> view) {
    this.view =view;
  }

  @Override
  public void injectModel(CategoryListContract.Model model) {
    this.model = model;
  }

  @Override
  public void fetchCategoryListData() {
    // Log.e(TAG, "fetchCategoryListData()");

    /*
    // set passed state
    String data = router.getDataFromPreviousScreen();
    if(data != null) {
        viewModel.data = data;
    }
    */

    // call the model

    viewModel.categories = model.fetchCategoryListData();
    view.get().displayCategoryListData(viewModel);

  }


  @Override
  public void selectCategoryListData(CategoryItem item) {
    router.passDataToProductListScreen(item);
    router.navigateToProductListScreen();
  }

}
