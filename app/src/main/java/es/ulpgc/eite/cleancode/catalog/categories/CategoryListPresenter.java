package es.ulpgc.eite.cleancode.catalog.categories;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;


public class CategoryListPresenter implements CategoryListContract.Presenter {

  public static String TAG = CategoryListPresenter.class.getSimpleName();


  private WeakReference<CategoryListContract.View> view;
  private CategoryListState state;
  private CategoryListContract.Model model;
  //private CategoryListContract.Router router;
  private CatalogMediator mediator;

  public CategoryListPresenter(CatalogMediator mediator) {
    this.mediator = mediator;
    state = mediator.getCategoryListState();
  }

//  public CategoryListPresenter(CategoryListState state) {
//    this.state = state;
//  }

  @Override
  public void fetchCategoryListData() {
    // Log.e(TAG, "fetchCategoryListData()");

    // call the model

    state.categories = model.fetchCategoryListData();
    view.get().displayCategoryListData(state);

  }

  @Override
  public void selectCategoryListData(CategoryItem item) {
    //router.passDataToProductListScreen(item);
    passDataToProductListScreen(item);
    //router.navigateToProductListScreen();
    view.get().navigateToProductListScreen();
  }


  private void passDataToProductListScreen(CategoryItem item) {
    mediator.setCategory(item);
  }

  @Override
  public void injectView(WeakReference<CategoryListContract.View> view) {
    this.view =view;
  }

  @Override
  public void injectModel(CategoryListContract.Model model) {
    this.model = model;
  }

//  @Override
//  public void injectRouter(CategoryListContract.Router router) {
//    this.router = router;
//  }


}
