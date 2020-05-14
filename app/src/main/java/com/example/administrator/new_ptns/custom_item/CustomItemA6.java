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

import java.util.ArrayList;

import butterknife.internal.ListenerClass;


/**
 * Created by tianxiying on 2018/3/1.
 */

public class CustomItemA6 extends LinearLayout {
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
    TextView tv_00,tv_01,tv_02,tv_03,tv_04;
    TextView tv_10,tv_11,tv_12,tv_13,tv_14;
    TextView tv_20,tv_21,tv_22,tv_23,tv_24;
    TextView tv_30,tv_31,tv_32,tv_33,tv_34;
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
        }else{
            txt.setVisibility(GONE);
        }
    }

    public void setTitleText2(String titleText) {
        if (titleText != null) {
            this.titleText2 = titleText;
            txt2.setText(titleText);
        }else{
            txt2.setVisibility(GONE);
        }
    }





    public void setDataList(String title1,String[] d1){
        datalist = d1;
        title = title1;
    }


    public CustomItemA6(Context context) {
        this(context, null);
    }

    public CustomItemA6(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomItemA6(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(final Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.custom_item_a6, this, true);
        txt = (TextView) mView.findViewById(R.id.textView103);
        txt2 = (TextView) mView.findViewById(R.id.textView104);
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.CustomItem1Attr);
        setTitleText(a.getString(R.styleable.CustomItem1Attr_txt1));
        setTitleText2(a.getString(R.styleable.CustomItem1Attr_txt2));
        tv_00 = mView.findViewById(R.id.t1extView163);
        tv_01 = mView.findViewById(R.id.t1extView263);
        tv_02 = mView.findViewById(R.id.t1extView363);
        tv_03 = mView.findViewById(R.id.t1extView463);
        tv_04 = mView.findViewById(R.id.t1extView);

        tv_10 = mView.findViewById(R.id.t2extView163);
        tv_11 = mView.findViewById(R.id.t2extView263);
        tv_12 = mView.findViewById(R.id.t2extView363);
        tv_13 = mView.findViewById(R.id.t2extView463);
        tv_14 = mView.findViewById(R.id.t2extView);

        tv_20 = mView.findViewById(R.id.t3extView163);
        tv_21 = mView.findViewById(R.id.t3extView263);
        tv_22 = mView.findViewById(R.id.t3extView363);
        tv_23 = mView.findViewById(R.id.t3extView463);
        tv_24 = mView.findViewById(R.id.t3extView);

        tv_30 = mView.findViewById(R.id.t4extView163);
        tv_31 = mView.findViewById(R.id.t4extView263);
        tv_32 = mView.findViewById(R.id.t4extView363);
        tv_33 = mView.findViewById(R.id.t4extView463);
        tv_34 = mView.findViewById(R.id.t4extView);
    }


    public void setViewOnlickListener(OnClickListener onlickListener) {
        this.onClickListener = onlickListener;
        mView.setOnClickListener(onlickListener);
    }

    public void setValue(ArrayList<String> list1){
        if(list1==null){
            return;
        }
        tv_00.setText(list1.get(0));
        tv_01.setText(list1.get(1));
        tv_02.setText(list1.get(2));
        tv_03.setText(list1.get(3));
        tv_04.setText(list1.get(4));

        tv_10.setText(list1.get(5));
        tv_11.setText(list1.get(6));
        tv_12.setText(list1.get(7));
        tv_13.setText(list1.get(8));
        tv_14.setText(list1.get(9));

        tv_20.setText(list1.get(10));
        tv_21.setText(list1.get(11));
        tv_22.setText(list1.get(12));
        tv_23.setText(list1.get(13));
        tv_24.setText(list1.get(14));

        tv_30.setText(list1.get(15));
        tv_31.setText(list1.get(16));
        tv_32.setText(list1.get(17));
        tv_33.setText(list1.get(18));
        tv_34.setText(list1.get(19));
    }

}
