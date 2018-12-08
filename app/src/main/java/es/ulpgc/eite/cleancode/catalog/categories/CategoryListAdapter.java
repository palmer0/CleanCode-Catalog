package es.ulpgc.eite.cleancode.catalog.categories;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;

public class CategoryListAdapter
    extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

  //private final List<CatalogItem> mValues;
  private final List<CategoryItem> mValues;
  private final View.OnClickListener mOnClickListener;


  public CategoryListAdapter(
      List<CategoryItem> items, View.OnClickListener listener) {
    mValues = items;
    mOnClickListener = listener;
  }

  /*
  public CategoryListAdapter(List<CatalogItem> items, View.OnClickListener listener) {
    mValues = items;
    mOnClickListener = listener;
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
