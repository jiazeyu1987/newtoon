package com.example.administrator.new_ptns.custom_item;

import android.content.Context;
import android.content.res.TypedArray;
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

public class CustomItemA1 extends LinearLayout {
    private Context mContext;
    private View mView;
    private ImageView icon;
    private TextView txt;
    private TextView txt2;
    private OnClickListener onClickListener;
    private String titleText;
    private String titleText2;
    private int iconImgId;
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
        if (titleText != null) {
            this.titleText2 = titleText;
            txt2.setHint(titleText);
        }
    }

    public void setTitleText3(String titleText) {
        txt2.setText(titleText);
        setTextMode();
    }

    public String getTitleText3() {
        return txt2.getText().toString();
    }







    public CustomItemA1(Context context) {
        this(context, null);
    }

    public CustomItemA1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomItemA1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.custom_item_a1, this, true);
        txt = (TextView) mView.findViewById(R.id.textView27);
        txt2 = (TextView) mView.findViewById(R.id.et_1);
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.CustomItem1Attr);
        setTextMode();
        setTitleText(a.getString(R.styleable.CustomItem1Attr_txt1));
        setTitleText2(a.getString(R.styleable.CustomItem1Attr_txt2));
        setTitleText3(a.getString(R.styleable.CustomItem1Attr_txt3));
        if(a.getBoolean(R.styleable.CustomItem1Attr_bool1,true)){
            setEditMode();
        }else{
            setTextMode();
        }
    }


    public void setViewOnlickListener(OnClickListener onlickListener) {
        this.onClickListener = onlickListener;
        mView.setOnClickListener(onlickListener);
    }

}
