package com.example.administrator.new_ptns.pager.template;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.pager.timing.PagerTimingItem;
import com.google.gson.Gson;
import com.kyleduo.switchbutton.SwitchButton;

import java.util.ArrayList;


class PagerTemplateAdapter extends BaseAdapter {
    private ArrayList<PagerTemplateItem> list;
    private Context context = null;

    public PagerTemplateAdapter(Context context, ArrayList<PagerTemplateItem> list1) {
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

    private void fresh_view(ViewHolder mHolder,PagerTemplateItem item ){
        mHolder.tv_name.setText(item.name);
        mHolder.tv_current.setText(item.current*1.0/1000+"");
        mHolder.tv_freq.setText(item.freq+"");
        mHolder.tv_pulse.setText(item.treatment_time+"");
        mHolder.tv_stim_time.setText(item.stim_time+"分钟");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder;
        if (convertView == null) {
            mHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_template, null, true);

            mHolder.tv_name = (TextView) convertView.findViewById(R.id.textView46);
            mHolder.tv_current = (TextView) convertView.findViewById(R.id.textView49);
            mHolder.tv_freq = (TextView) convertView.findViewById(R.id.textView50);
            mHolder.tv_pulse = (TextView) convertView.findViewById(R.id.textView51);
            mHolder.tv_stim_time = (TextView) convertView.findViewById(R.id.textView47);
            mHolder.iv = convertView.findViewById(R.id.imageView29);
            convertView.setTag(mHolder);
        }
        mHolder = (ViewHolder) convertView.getTag();
        final PagerTemplateItem item = list.get(position);
        fresh_view(mHolder,item);
        mHolder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,NewTemplateActivity.class);
                Gson gson = new Gson();
                String s1 = gson.toJson(item);
                intent.putExtra("extra",s1);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    class ViewHolder {
        private TextView tv_name;
        private TextView tv_current;
        private TextView tv_freq;
        private TextView tv_pulse;
        private TextView tv_stim_time;
        private ImageView iv;
    }
}