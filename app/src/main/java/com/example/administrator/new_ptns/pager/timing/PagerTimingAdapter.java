package com.example.administrator.new_ptns.pager.timing;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.administrator.new_ptns.R;
import com.google.gson.Gson;
import com.kyleduo.switchbutton.SwitchButton;

import java.util.ArrayList;


class PagerTimingAdapter extends BaseAdapter {
    private ArrayList<PagerTimingItem> list;
    private Context context = null;

    public PagerTimingAdapter(Context context, ArrayList<PagerTimingItem> list1) {
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

    private void fresh_view(ViewHolder mHolder,PagerTimingItem item ){
        mHolder.time_tar.setText(item.time_tar);
        mHolder.time_cal.setText(item.time_cal);
        mHolder.time_day.setText(item.time_day);
        if(item.open){
            mHolder.open_switch.setChecked(true);
            mHolder.time_tar.setTextColor(context.getResources().getColor(R.color.green1));
        }else{
            mHolder.open_switch.setChecked(false);
            mHolder.time_tar.setTextColor(context.getResources().getColor(R.color.gray1));
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder2;
        if (convertView == null) {
            mHolder2 = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_timing, null, true);
            mHolder2.time_tar = (TextView) convertView.findViewById(R.id.textView31);
            mHolder2.time_cal = (TextView) convertView.findViewById(R.id.textView32);
            mHolder2.time_day = (TextView) convertView.findViewById(R.id.textView33);
            mHolder2.open_switch = (SwitchButton) convertView.findViewById(R.id.switch1);
            convertView.setTag(mHolder2);
        }
        final ViewHolder mHolder = (ViewHolder) convertView.getTag();
        final PagerTimingItem item = list.get(position);
        fresh_view(mHolder,item);

        mHolder.open_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(item.open){
                    item.open = false;
                    mHolder.open_switch.setChecked(true);
                }else{
                    item.open = true;
                    mHolder.open_switch.setChecked(false);
                }
                TimeDao dao = new TimeDao(context);
                dao.modify(item);
                notifyDataSetChanged();
            }
        });

        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PagerTimingItem item1 = item;
                Gson gson = new Gson();
                String s1 = gson.toJson(item1);
                Intent intent = new Intent(context, NewTimingActivity.class);
                intent.putExtra("extra_value",s1);
                context.startActivity(intent);
                return false;
            }
        });


        return convertView;
    }

    class ViewHolder {
        private TextView time_tar;
        private TextView time_cal;
        private TextView time_day;
        private SwitchButton open_switch;
    }
}