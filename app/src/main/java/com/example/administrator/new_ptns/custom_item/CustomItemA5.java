package com.example.administrator.new_ptns.custom_item;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.new_ptns.R;

import java.text.NumberFormat;


/**
 * Created by tianxiying on 2018/3/1.
 */

public class CustomItemA5 extends LinearLayout {
    private Context mContext;
    private View mView;
    private ImageView icon;
    private TextView txt;
    private TextView txt2;
    private TextView txt3;
    private OnClickListener onClickListener;
    private String titleText;
    private String titleText2;
    private String titleText3;
    private int iconImgId;
    public String[] datalist = null;
    public static final int NO_LINE = 0;
    public String title = "";
    Button btn1,btn2,btn3,btn4;
    public float value = 0;
    public float min_value = 0;
    public float max_value = 0;
    public float step_value_min = 0;
    public float step_value_max = 0;
    public int getIconImgId() {
        return iconImgId;
    }

    public void setIconImgId(int iconImgId) {
        if (iconImgId != 10000) {
            this.iconImgId = iconImgId;
            icon.setImageResource(this.iconImgId);
        }
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        if (titleText != null) {
            this.titleText = titleText;
            txt.setText(titleText);
        }
    }

    public void setTitleText2(String titleText) {
        if (titleText != null) {
            this.titleText2 = titleText;
            txt2.setText(titleText);
        }
    }

    public void setTitleText3(String titleText) {
        if (titleText != null) {
            this.titleText3 = titleText;
            txt3.setText(titleText);
        }
    }




    public void setDataList(String title1,String[] d1){
        datalist = d1;
        title = title1;
    }


    public CustomItemA5(Context context) {
        this(context, null);
    }

    public CustomItemA5(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomItemA5(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void set_value(float d1){
        value = d1;


        value = Math.round((d1*100))/100f;
        txt2.setText(value+"");
    }

    public String getTitleText2(){
        return txt2.getText().toString();
    }

    private void init(final Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.custom_item_a5, this, true);
        txt = (TextView) mView.findViewById(R.id.textView27);
        txt2 = (TextView) mView.findViewById(R.id.textView75);
        txt3 = (TextView) mView.findViewById(R.id.textView76);
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.CustomItem1Attr);
        setTitleText(a.getString(R.styleable.CustomItem1Attr_txt1));
        setTitleText2(a.getString(R.styleable.CustomItem1Attr_txt2));
        setTitleText3(a.getString(R.styleable.CustomItem1Attr_txt3));
        value = a.getFloat(R.styleable.CustomItem1Attr_float0,0);
        min_value = a.getFloat(R.styleable.CustomItem1Attr_float1,-1);
        max_value = a.getFloat(R.styleable.CustomItem1Attr_float2,-1);
        step_value_min = a.getFloat(R.styleable.CustomItem1Attr_float3,0);
        step_value_max = a.getFloat(R.styleable.CustomItem1Attr_float4,0);
        btn1 = mView.findViewById(R.id.button12);
        btn2 = mView.findViewById(R.id.button13);
        btn3 = mView.findViewById(R.id.button14);
        btn4 = mView.findViewById(R.id.button18);
        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(value-step_value_max<min_value){
                    return;
                }
                else{
                    set_value(value-step_value_max);
                }
            }
        });
        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(value-step_value_min<min_value){
                    return;
                }
                else{
                    set_value(value-step_value_min);
                }
            }
        });
        btn3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(value+step_value_min>max_value){
                    return;
                }
                else{
                    set_value(value+step_value_min);
                }
            }
        });
        btn4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(value+step_value_max>max_value){
                    return;
                }
                else{
                    set_value(value+step_value_max);
                }
            }
        });
    }


    public void setPara(float default_value,float min_step,float max_step,float min_value1,float max_value1,String danwei){
        step_value_min = min_step;
        step_value_max = max_step;
        set_value(default_value);
        min_value = min_value1;
        max_value = max_value1;
        txt3.setText(danwei);
    }

    public void setViewOnlickListener(OnClickListener onlickListener) {
        this.onClickListener = onlickListener;
        mView.setOnClickListener(onlickListener);
    }

}
