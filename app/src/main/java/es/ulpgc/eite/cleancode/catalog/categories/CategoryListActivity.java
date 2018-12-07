package es.ulpgc.eite.cleancode.catalog.categories;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.adapter.CatalogRecyclerViewAdapter;
import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;


public class CategoryListActivity
    extends AppCompatActivity implements CategoryListContract.View {

  public static String TAG = CategoryListActivity.class.getSimpleName();

  CategoryListContract.Presenter presenter;

  private RecyclerView recyclerView;

//  private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
//
//    @Override
//    public void onClick(View view) {
//      CatalogItem item = (CatalogItem) view.getTag();
//
//      Context context = view.getContext();
//      //Intent intent = new Intent(context, CategoryDetailActivity.class);
//      Intent intent = new Intent(context, ProductListActivity.class);
//      //intent.putExtra(CategoryDetailFragment.ARG_ITEM_ID, item.id);
//      intent.putExtra(ProductListActivity.ARG_ITEM_ID, item.id);
//
//      context.startActivity(intent);
//
//      /*
//      if (mTwoPane) {
//        Bundle arguments = new Bundle();
//        arguments.putString(CategoryDetailFragment.ARG_ITEM_ID, item.id);
//        CategoryDetailFragment fragment = new CategoryDetailFragment();
//        fragment.setArguments(arguments);
//        mParentActivity.getSupportFragmentManager().beginTransaction()
//            .replace(R.id.category_detail_container, fragment)
//            .commit();
//      } else {
//        Context context = view.getContext();
//        //Intent intent = new Intent(context, CategoryDetailActivity.class);
//        Intent intent = new Intent(context, ProductListActivity.class);
//        //intent.putExtra(CategoryDetailFragment.ARG_ITEM_ID, item.id);
//        intent.putExtra(ProductListActivity.ARG_ITEM_ID, item.id);
//
//        context.startActivity(intent);
//      }
//      */
//    }
//  };


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_category_list);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setTitle(getTitle());
    //toolbar.setTitle(R.string.title_category_list);

    // Show the Up button in the action bar.
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      //actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(R.string.app_title);
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
        new CatalogRecyclerViewAdapter(
            viewModel.categories, new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            CatalogItem item = (CatalogItem) view.getTag();
            //presenter.selectCategoryListData(item.id);
            presenter.selectCategoryListData(item);
          }
        })
    );

    /*
    recyclerView.setAdapter(
        new CatalogRecyclerViewAdapter(viewModel.itemList, mOnClickListener)
    );
    */
  }


}
