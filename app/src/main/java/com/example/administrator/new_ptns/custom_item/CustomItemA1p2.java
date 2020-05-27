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

public class CustomItemA1p2 extends LinearLayout {
    private Context mContext;
    private View mView;
    private ImageView icon;
    private TextView txt;
    private EditText txt2;
    private OnClickListener onClickListener;
    private String titleText;
    private String titleText2;
    private int iconImgId;
    public static final int NO_LINE = 0;
    public Button btn1,btn2;
    public String[] datalist1 = new String[]{"L","R","/"};
    public String[] datalist2 = new String[]{"规格1","规格2","无"};
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
    public String getTitleText2() {
        return txt2.getText().toString();
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




    public String getBtn1Text(){
        return btn1.getText().toString();
    }
    public String getBtn2Text(){
        return btn2.getText().toString();
    }
    public String getEditText(){
        return txt2.getText().toString();
    }



    public CustomItemA1p2(Context context) {
        this(context, null);
    }

    public CustomItemA1p2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomItemA1p2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.custom_item_a1p2, this, true);
        btn1 = mView.findViewById(R.id.button22);
        btn2 = mView.findViewById(R.id.button23);
        txt = (TextView) mView.findViewById(R.id.textView27);
        txt2 = mView.findViewById(R.id.et_1);
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.CustomItem1Attr);
        setTitleText(a.getString(R.styleable.CustomItem1Attr_txt1));

        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                final Context c1 = mContext;
                AlertDialog.Builder builder = new AlertDialog.Builder(c1);
                builder.setTitle("请选择电极位置");
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher)
                        .setItems(datalist1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                btn1.setText(datalist1[which]);
                            }
                        }).create()
                        .show();
            }
        });


        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                final Context c1 = mContext;
                AlertDialog.Builder builder = new AlertDialog.Builder(c1);
                builder.setTitle("请选择规格");
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher)
                        .setItems(datalist2, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                btn2.setText(datalist2[which]);
                            }
                        }).create()
                        .show();
            }
        });
    }


    public void setViewOnlickListener(OnClickListener onlickListener) {
        this.onClickListener = onlickListener;
        mView.setOnClickListener(onlickListener);
    }

}
