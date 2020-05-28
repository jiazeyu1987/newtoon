package com.example.administrator.new_ptns.custom_item;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.support.v7.app.AlertDialog;
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
    public Button btn1;
    public EditText edt1;
    public String title;
    public String[] list1;
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


    public void setEditMode(){
        edt1.setVisibility(VISIBLE);
        txt2.setVisibility(INVISIBLE);
        btn1.setVisibility(INVISIBLE);
    }

    public void setTextMode(){
        this.txt2.setVisibility(VISIBLE);
        this.btn1.setVisibility(INVISIBLE);
        edt1.setVisibility(INVISIBLE);
    }

    public void setBtnMode(){
        btn1.setVisibility(VISIBLE);
        txt2.setVisibility(INVISIBLE);
        edt1.setVisibility(INVISIBLE);
    }

    public void setTitleText2(String titleText) {
        setTextMode();
        txt2.setText(titleText);
    }

    public void setDatalist(String title11,String[] list11){
        title = title11;
        list1 = list11;
        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                final Context c1 = mContext;
                AlertDialog.Builder builder = new AlertDialog.Builder(c1);
                builder.setTitle(title);
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher)
                        .setItems(list1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                btn1.setText(list1[which]);
                            }
                        }).create()
                        .show();
            }
        });
    }

    public String  getTitleText2() {
        return txt2.getText().toString();
    }

    public void setTitleText3(String titleText) {
        txt3.setText(titleText);
    }

    public void setTitleText4(String titleText) {
        txt4.setText(titleText);
    }

    public void setBtn1(String s1){
        btn1.setText(s1);
        setBtnMode();

    }

    public void setedt1(boolean b){
        if(b){
        setEditMode();}
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
        edt1 = mView.findViewById(R.id.eddads);
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.CustomItem1Attr);
        setTitleText(a.getString(R.styleable.CustomItem1Attr_txt1));
        setTitleText2(a.getString(R.styleable.CustomItem1Attr_txt2));
        setTitleText3(a.getString(R.styleable.CustomItem1Attr_txt3));
        setTitleText4(a.getString(R.styleable.CustomItem1Attr_txt4));
        setBtn1(a.getString(R.styleable.CustomItem1Attr_btn1));
        setedt1(a.getBoolean(R.styleable.CustomItem1Attr_bool1,false));

    }


    public void setViewOnlickListener(OnClickListener onlickListener) {
        this.onClickListener = onlickListener;
        mView.setOnClickListener(onlickListener);
    }

}
