package es.ulpgc.eite.cleancode.catalog.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;


public class ProductDetailActivity
    extends AppCompatActivity implements ProductDetailContract.View {

  public static String TAG = ProductDetailActivity.class.getSimpleName();

  ProductDetailContract.Presenter presenter;

  //private CatalogItem mItem;
  //CatalogRepository repository = new CatalogRepository();
  private CollapsingToolbarLayout appBarLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_product_detail);
    Toolbar toolbar = findViewById(R.id.detail_toolbar);
    setSupportActionBar(toolbar);

    // Show the Up button in the action bar.
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
    }

    appBarLayout = findViewById(R.id.toolbar_layout);

    /*
    mItem = repository.getItemMap().get(getArguments().getString(ARG_ITEM_ID));

    CollapsingToolbarLayout appBarLayout = findViewById(R.id.toolbar_layout);
    if (appBarLayout != null) {
      appBarLayout.setTitle(mItem.content);
    }
    */

    // do the setup
    ProductDetailConfigurator.INSTANCE.configure(this);

    // do some work
    presenter.fetchProductDetailData();
  }

  @Override
  public void displayProductDetailData(ProductDetailViewModel viewModel) {
    Log.e(TAG, "displayProductDetailData()");

    // deal with the data
    CatalogItem product = viewModel.product;
    if (product != null) {
      if (appBarLayout != null) {
        appBarLayout.setTitle(product.content);
      }


      ((TextView) findViewById(R.id.product_detail)).setText(product.details);
    }
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == android.R.id.home) {
      // This ID represents the Home or Up button. In the case of this
      // activity, the Up button is shown. For
      // more details, see the Navigation pattern on Android Design:
      //
      // http://developer.android.com/design/patterns/navigation.html#up-vs-back
      //
      navigateUpTo(new Intent(this, ProductListActivity.class));
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
