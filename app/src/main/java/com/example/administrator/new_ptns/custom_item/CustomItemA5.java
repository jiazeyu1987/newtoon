package com.example.administrator.new_ptns.custom_item;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.new_ptns.R;


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
    }


    public void setViewOnlickListener(OnClickListener onlickListener) {
        this.onClickListener = onlickListener;
        mView.setOnClickListener(onlickListener);
    }

}
