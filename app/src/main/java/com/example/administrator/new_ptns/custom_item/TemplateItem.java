package com.example.administrator.new_ptns.custom_item;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.administrator.new_ptns.R;

public class TemplateItem extends LinearLayout {
    Context mContext;
    View mView;
    ImageView iv;
    public String name = "";
    int iconImgId;
    public int value;
    TextView ti_tv1,ti_tv2;
    TextView tv_show;
    SeekBar seekBar;
    ImageView plus,minus;
    public void setIconImgId(int iconImgId) {
        if (iconImgId != 10000) {
            this.iconImgId = iconImgId;
            iv.setImageResource(iconImgId);
        }
    }

    public void setText(String t1,String t2){
        ti_tv1.setText(t1);
        ti_tv2.setText("("+t2+")");
    }

    public TemplateItem(Context context) {
        this(context, null);
    }

    public TemplateItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TemplateItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.custom_template_unit, this, true);
        iv = (ImageView) mView.findViewById(R.id.saa);
        ti_tv1 = (TextView) mView.findViewById(R.id.ti_tv1);
        ti_tv2 = (TextView) mView.findViewById(R.id.ti_tv2);
        tv_show = mView.findViewById(R.id.textView13);
        plus = mView.findViewById(R.id.saa3);
        minus = mView.findViewById(R.id.saa2);
        seekBar = mView.findViewById(R.id.seekBar);

        plus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(value<seekBar.getMax())
                seekBar.setProgress(value+1);
            }
        });

        minus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(value>0)
                seekBar.setProgress(value-1);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                value = i;
                fresh_value();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.TemplateItem);
        setIconImgId(a.getResourceId(R.styleable.TemplateItem_icon_reference, 10000));
    }

    public void set_value(int value){
        seekBar.setProgress(value);
    }
    private void fresh_value(){
        tv_show.setText(value+"");
    }
}
