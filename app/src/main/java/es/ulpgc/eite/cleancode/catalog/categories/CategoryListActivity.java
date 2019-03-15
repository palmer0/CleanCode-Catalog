package es.ulpgc.eite.cleancode.catalog.categories;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;


public class CategoryListActivity
    extends AppCompatActivity implements CategoryListContract.View {

  public static String TAG = CategoryListActivity.class.getSimpleName();

  CategoryListContract.Presenter presenter;

  //private ListView listView;
  private CategoryListAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_category_list);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    // Show the Up button in the action bar.
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle(R.string.app_name);
    }

    listAdapter = new CategoryListAdapter(this, new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        CategoryItem item = (CategoryItem) view.getTag();
        presenter.selectCategoryListData(item);
      }
    });

    ListView listView = findViewById(R.id.category_list);
    //listView = findViewById(R.id.category_list);
    listView.setAdapter(listAdapter);

    /*
    listView.setAdapter(
        new CategoryListAdapter(this, new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            CategoryItem item = (CategoryItem) view.getTag();
            presenter.selectCategoryListData(item);
          }
        })
    );
    */

    // do the setup
    CategoryListScreen.configure(this);

    // do some work
    presenter.fetchCategoryListData();
  }


  @Override
  public void displayCategoryListData(CategoryListViewModel viewModel) {
    Log.e(TAG, "displayCategoryListData()");

    // deal with the data
    listAdapter.setItems(viewModel.categories);
    //((CategoryListAdapter) listView.getAdapter()).setItems(viewModel.categories);

    /*
    listView.setAdapter(new CategoryListAdapter(
        this, viewModel.categories, new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            CategoryItem item = (CategoryItem) view.getTag();
            presenter.selectCategoryListData(item);
          }
        })
    );
    */
  }


  @Override
  public void injectPresenter(CategoryListContract.Presenter presenter) {
    this.presenter = presenter;
  }

}
