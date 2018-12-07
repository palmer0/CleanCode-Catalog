package es.ulpgc.eite.cleancode.catalog.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;

public class CatalogRecyclerViewAdapter
    extends RecyclerView.Adapter<CatalogRecyclerViewAdapter.ViewHolder> {

  //private final AppCompatActivity mParentActivity;
  private final List<CatalogItem> mValues;
  private final View.OnClickListener mOnClickListener;
  //private final boolean mTwoPane;


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

  public CatalogRecyclerViewAdapter(List<CatalogItem> items, View.OnClickListener listener) {
    mValues = items;
    mOnClickListener = listener;
  }

  /*
  CatalogRecyclerViewAdapter(AppCompatActivity parent, List<CatalogItem> items, boolean twoPane) {
    mValues = items;
    mParentActivity = parent;
    mTwoPane = twoPane;
  }
  */

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.category_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    //holder.mIdView.setText(mValues.get(position).id);
    holder.mContentView.setText(mValues.get(position).content);

    holder.itemView.setTag(mValues.get(position));
    holder.itemView.setOnClickListener(mOnClickListener);
  }

  @Override
  public int getItemCount() {
    return mValues.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    //final TextView mIdView;
    final TextView mContentView;

    ViewHolder(View view) {
      super(view);
      //mIdView = view.findViewById(R.id.id_text);
      mContentView = view.findViewById(R.id.content);
    }
  }
}
