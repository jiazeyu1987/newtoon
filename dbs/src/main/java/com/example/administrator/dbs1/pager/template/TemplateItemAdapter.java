package com.example.administrator.dbs1.pager.template;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.dbs1.custom_item.TemplateItem;

import java.util.ArrayList;



class TemplateItemAdapter extends BaseAdapter {
    private ArrayList<TemplateItem> list  ;
    private Context context = null;
    public TemplateItemAdapter(Context context,ArrayList<TemplateItem> list1) {
        this.context = context;
        list = list1;
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return list.get(position);
    }

    class ViewHolder {
        private TextView text_item_name;
        private TextView text_item_id;
        private ImageView imageView;
    }
}