package es.ulpgc.eite.cleancode.catalog.products;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.data.ProductItem;

public class ProductListAdapter extends ArrayAdapter<ProductItem> {

  //private final List<ProductItem> itemList;
  private List<ProductItem> itemList = new ArrayList();
  private final View.OnClickListener clickListener;

  public ProductListAdapter(Context context, View.OnClickListener listener) {
    super(context, 0, new ArrayList());

    clickListener = listener;
  }

  /*
  public ProductListAdapter(
      Context context, List<ProductItem> items, View.OnClickListener listener) {

    super(context, 0, items);

    itemList = items;
    clickListener = listener;
  }
  */


  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View itemView = convertView;

    if(itemView == null) {
      itemView = LayoutInflater
          .from(parent.getContext())
          .inflate(R.layout.product_list_content, parent, false);
    }

    itemView.setTag(itemList.get(position));
    itemView.setOnClickListener(clickListener);

    final TextView contentView = itemView.findViewById(R.id.content);
    contentView.setText(itemList.get(position).content);

    return itemView;
  }


  public void addItem(ProductItem item){
    itemList.add(item);
  }

  public void addItems(List<ProductItem> items){
    itemList.addAll(items);
  }

  public void setItems(List<ProductItem> items){
    itemList = items;
  }

  @Override
  public int getCount() {
    return itemList.size();
  }

  @Override
  public ProductItem getItem(int position) {
    return itemList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return getItem(position).id;
  }


}
