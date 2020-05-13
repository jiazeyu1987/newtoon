package com.example.administrator.new_ptns.custom_item;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.data_handler.PatientData;
import com.example.administrator.new_ptns.pager.patient_info.PagerPatientInfo;


/**
 * Created by tianxiying on 2018/3/1.
 */

public class CustomItemA9 extends LinearLayout {
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
    Button btn1;
    int state = 1;
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


    public CustomItemA9(Context context) {
        this(context, null);
    }

    public CustomItemA9(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomItemA9(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(final Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.pager_nt_three_1_item_unit, this, true);
        txt = mView.findViewById(R.id.textView116);
        txt2 = mView.findViewById(R.id.textView117);
        txt3 = mView.findViewById(R.id.textView118);
        icon = mView.findViewById(R.id.imageView49);
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.CustomItem1Attr);
        setTitleText(a.getString(R.styleable.CustomItem1Attr_txt1));
        setTitleText2(a.getString(R.styleable.CustomItem1Attr_txt2));
        setTitleText3(a.getString(R.styleable.CustomItem1Attr_txt3));
        setIconImgId(a.getResourceId(R.styleable.CustomItem1Attr_icon1,R.mipmap.dianliu));
    }

//    public void set_para(int resourceID,String txt11,String txt21,String txt31){
//        setTitleText(txt11);
//        setTitleText2(txt21);
//        setTitleText3(txt31);
//        setIconImgId(resourceID);
//    }

    public void set_user_data(PatientData data){
        if(data==null){
            this.setVisibility(GONE);
            return;
        }
        setTitleText(data.name+" "+data.sex+" "+data.age+"岁");
        setTitleText2("最近手术日期："+data.last_operation_date);
        setTitleText3("最近调试日期："+data.last_debug_date);
    }


    public void setViewOnlickListener(OnClickListener onlickListener) {
        this.onClickListener = onlickListener;
        mView.setOnClickListener(onlickListener);
    }

}
