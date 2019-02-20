package es.ulpgc.eite.cleancode.catalog.categories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;

public class CategoryListAdapter extends ArrayAdapter<CategoryItem> {
    //extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

  private final List<CategoryItem> itemList;
  private final View.OnClickListener clickListener;




  public CategoryListAdapter(
      Context context, List<CategoryItem> items, View.OnClickListener listener) {

    super(context, 0, items);
    itemList = items;
    clickListener = listener;
  }

  /*
  public CategoryListAdapter(
      List<CategoryItem> items, View.OnClickListener listener) {

    itemList = items;
    clickListener = listener;
  }
  */

  @Override
  public int getCount() {
    return itemList.size();
  }

  @Override
  public CategoryItem getItem(int position) {
    return itemList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return getItem(position).id;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View itemView = convertView;

    if(itemView == null) {
      itemView = LayoutInflater
          .from(parent.getContext())
          .inflate(R.layout.category_list_content, parent, false);
    }

    itemView.setTag(itemList.get(position));
    itemView.setOnClickListener(clickListener);

    //CategoryItem item = getItem(position);

    final TextView contentView = itemView.findViewById(R.id.content);
    contentView.setText(itemList.get(position).content);

    return itemView;
  }

  /*
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.category_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.contentView.setText(itemList.get(position).content);

    holder.itemView.setTag(itemList.get(position));
    holder.itemView.setOnClickListener(clickListener);
  }

  @Override
  public int getItemCount() {
    return itemList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView contentView;

    ViewHolder(View view) {
      super(view);
      contentView = view.findViewById(R.id.content);
    }
  }
  */
}
