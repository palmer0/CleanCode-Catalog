package es.ulpgc.eite.cleancode.catalog.categories;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;


public class CategoryListPresenter implements CategoryListContract.Presenter {

  public static String TAG = CategoryListPresenter.class.getSimpleName();


  private WeakReference<CategoryListContract.View> view;
  private CategoryListViewModel viewModel;
  private CategoryListContract.Model model;
  private CategoryListContract.Router router;

  public CategoryListPresenter(CategoryListState state) {
    viewModel = state;
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
  public void injectRouter(CategoryListContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchCategoryListData() {
    // Log.e(TAG, "fetchCategoryListData()");

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
