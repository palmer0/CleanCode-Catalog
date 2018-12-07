package es.ulpgc.eite.cleancode.catalog.products;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.adapter.CatalogRecyclerViewAdapter;
import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;


public class ProductListActivity
    extends AppCompatActivity implements ProductListContract.View {

  public static String TAG = ProductListActivity.class.getSimpleName();

  ProductListContract.Presenter presenter;

  //private CatalogItem mItem;
  //private CatalogRepository repository = new CatalogRepository();

  private RecyclerView recyclerView;
  //private Toolbar toolbar;
  private ActionBar actionBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_product_list);

    /*
    mItem = repository.getItemMap().get(
        getIntent().getStringExtra(CategoryDetailFragment.ARG_ITEM_ID)
    );
    */

    Toolbar toolbar = findViewById(R.id.toolbar);
    //toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    //toolbar.setTitle(getTitle());
    //toolbar.setTitle(mItem.content);

    // Show the Up button in the action bar.
    actionBar = getSupportActionBar();
    //ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
    }

    recyclerView = findViewById(R.id.product_list);

    // do the setup
    ProductListConfigurator.INSTANCE.configure(this);

    // do some work
    presenter.fetchProductListData();
  }

  @Override
  public void displayProductListData(ProductListViewModel viewModel) {
    Log.e(TAG, "displayProductListData()");

    // deal with the data
    CatalogItem category = viewModel.category;
    //toolbar.setTitle(category.content);
    if (actionBar != null) {
      actionBar.setTitle(category.content);
    }

    recyclerView.setAdapter(
        new CatalogRecyclerViewAdapter(
            viewModel.products, new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            CatalogItem item = (CatalogItem) view.getTag();
            presenter.selectProductListData(item);
          }
        })
    );
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == android.R.id.home) {
      // This ID represents the Home or Up button. In the case of this
      // activity, the Up button is shown. Use NavUtils to allow users
      // to navigate up one level in the application structure. For
      // more details, see the Navigation pattern on Android Design:
      //
      // http://developer.android.com/design/patterns/navigation.html#up-vs-back
      //
      NavUtils.navigateUpFromSameTask(this);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
