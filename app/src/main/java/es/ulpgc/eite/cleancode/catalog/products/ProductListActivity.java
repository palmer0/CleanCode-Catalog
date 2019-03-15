package es.ulpgc.eite.cleancode.catalog.products;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;


public class ProductListActivity
    extends AppCompatActivity implements ProductListContract.View {

  public static String TAG = ProductListActivity.class.getSimpleName();

  ProductListContract.Presenter presenter;

  //private ListView listView;
  private ActionBar actionBar;
  private ProductListAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_product_list);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    // Show the Up button in the action bar.
    actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
    }

    listAdapter = new ProductListAdapter(this, new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        ProductItem item = (ProductItem) view.getTag();
        presenter.selectProductListData(item);
      }
    });

    ListView listView = findViewById(R.id.product_list);
    //listView = findViewById(R.id.product_list);
    listView.setAdapter(listAdapter);

    // do the setup
    ProductListScreen.configure(this);

    // do some work
    presenter.fetchProductListData();
  }


  @Override
  public void displayProductListData(ProductListViewModel viewModel) {
    Log.e(TAG, "displayProductListData()");

    // deal with the data
    listAdapter.setItems(viewModel.products);

    CategoryItem category = viewModel.category;
    if (actionBar != null) {
      actionBar.setTitle(category.content);
    }


    /*
    listView.setAdapter(new ProductListAdapter(
        this, viewModel.products, new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            ProductItem item = (ProductItem) view.getTag();
            presenter.selectProductListData(item);
          }
        })
    );
    */
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == android.R.id.home) {
      NavUtils.navigateUpFromSameTask(this);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }


  @Override
  public void injectPresenter(ProductListContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
