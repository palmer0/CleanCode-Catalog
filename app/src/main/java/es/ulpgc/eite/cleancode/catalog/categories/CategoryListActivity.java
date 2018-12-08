package es.ulpgc.eite.cleancode.catalog.categories;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;


public class CategoryListActivity
    extends AppCompatActivity implements CategoryListContract.View {

  public static String TAG = CategoryListActivity.class.getSimpleName();

  CategoryListContract.Presenter presenter;

  private RecyclerView recyclerView;


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

    recyclerView = findViewById(R.id.category_list);

    // do the setup
    CategoryListConfigurator.INSTANCE.configure(this);

    // do some work
    presenter.fetchCategoryListData();
  }

  @Override
  public void displayCategoryListData(CategoryListViewModel viewModel) {
    Log.e(TAG, "displayCategoryListData()");

    // deal with the data
    recyclerView.setAdapter(
        new CategoryListAdapter(viewModel.categories, new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            CategoryItem item = (CategoryItem) view.getTag();
            presenter.selectCategoryListData(item);
          }
        })
    );

  }

}
