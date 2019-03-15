package es.ulpgc.eite.cleancode.catalog.categories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.data.CategoryItem;

public class CategoryListAdapter extends ArrayAdapter<CategoryItem> {

  //private final List<CategoryItem> itemList
  private List<CategoryItem> itemList = new ArrayList();
  private final View.OnClickListener clickListener;

  public CategoryListAdapter(Context context, View.OnClickListener listener) {
    super(context, 0, new ArrayList());

    clickListener = listener;
  }

  /*
  public CategoryListAdapter(
      Context context, List<CategoryItem> items, View.OnClickListener listener) {

    super(context, 0, items);
    itemList = items;
    clickListener = listener;
  }
  */


  public void addItem(CategoryItem item){
    itemList.add(item);
  }

  public void addItems(List<CategoryItem> items){
    itemList.addAll(items);
  }

  public void setItems(List<CategoryItem> items){
    itemList = items;
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

    final TextView contentView = itemView.findViewById(R.id.content);
    contentView.setText(itemList.get(position).content);

    return itemView;
  }


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


}
