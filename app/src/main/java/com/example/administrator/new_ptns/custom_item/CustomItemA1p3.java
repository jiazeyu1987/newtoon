package com.example.administrator.new_ptns.custom_item;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.new_ptns.R;


/**
 * Created by tianxiying on 2018/3/1.
 */

public class CustomItemA1p3 extends LinearLayout {
    private Context mContext;
    private View mView;
    private ImageView icon;
    private TextView txt;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private OnClickListener onClickListener;
    private String titleText;
    private String titleText2;
    private int iconImgId;
    private Button btn1;
    public static final int NO_LINE = 0;

    public int getIconImgId() {
        return iconImgId;
    }

    public void setIconImgId(int iconImgId) {
        if (iconImgId != 10000) {
            this.iconImgId = iconImgId;
            icon.setImageResource(this.iconImgId);
        }
    }

    public void setIconVisible(boolean vi){
        if(vi){
            icon.setVisibility(VISIBLE);
        }else{
            icon.setVisibility(INVISIBLE);
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

    public void setTextMode(){
        txt2.setEnabled(false);
    }

    public void setEditMode(){
        txt2.setEnabled(true);
    }

    public void setTitleText2(String titleText) {
        this.txt2.setVisibility(VISIBLE);
        this.btn1.setVisibility(INVISIBLE);
        txt2.setText(titleText);
    }

    public void setTitleText3(String titleText) {
        txt3.setText(titleText);
    }

    public void setTitleText4(String titleText) {
        txt4.setText(titleText);
    }

    public void setBtn1(String s1){
        btn1.setVisibility(VISIBLE);
        txt2.setVisibility(INVISIBLE);
        btn1.setText(s1);
    }





    public CustomItemA1p3(Context context) {
        this(context, null);
    }

    public CustomItemA1p3(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomItemA1p3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.custom_item_a1p3, this, true);
        txt = (TextView) mView.findViewById(R.id.textView27);
        btn1 =  mView.findViewById(R.id.button22);
        txt2 =  mView.findViewById(R.id.et_3);
        txt3  =  mView.findViewById(R.id.et_1);
        txt4  =  mView.findViewById(R.id.et_2);
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.CustomItem1Attr);
        setTitleText(a.getString(R.styleable.CustomItem1Attr_txt1));
        setTitleText2(a.getString(R.styleable.CustomItem1Attr_txt2));
        setTitleText3(a.getString(R.styleable.CustomItem1Attr_txt3));
        setTitleText4(a.getString(R.styleable.CustomItem1Attr_txt4));
        setBtn1(a.getString(R.styleable.CustomItem1Attr_btn1));
    }


    public void setViewOnlickListener(OnClickListener onlickListener) {
        this.onClickListener = onlickListener;
        mView.setOnClickListener(onlickListener);
    }

}
