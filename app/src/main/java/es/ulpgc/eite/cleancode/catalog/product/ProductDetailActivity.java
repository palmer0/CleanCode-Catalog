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
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;


public class ProductDetailActivity
    extends AppCompatActivity implements ProductDetailContract.View {

  public static String TAG = ProductDetailActivity.class.getSimpleName();

  ProductDetailContract.Presenter presenter;

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

    // do the setup
    ProductDetailConfigurator.INSTANCE.configure(this);

    // do some work
    presenter.fetchProductDetailData();
  }

  @Override
  public void displayProductDetailData(ProductDetailViewModel viewModel) {
    Log.e(TAG, "displayProductDetailData()");

    // deal with the data
    ProductItem product = viewModel.product;
    //ProductItem product = (ProductItem) viewModel.product;
    //CatalogItem product = viewModel.product;

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
      navigateUpTo(new Intent(this, ProductListActivity.class));
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
