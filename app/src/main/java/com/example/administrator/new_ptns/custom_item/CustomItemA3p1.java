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


/**
 * Created by tianxiying on 2018/3/1.
 */

public class CustomItemA3p1 extends LinearLayout {
    private Context mContext;
    private View mView;
    private ImageView icon;
    private TextView txt;
    private TextView txt2;
    private OnClickListener onClickListener;
    private String titleText;
    private String titleText2;
    private int iconImgId;
    public String[] datalist = null;
    public static final int NO_LINE = 0;
    public String title = "";
    Button btn1;
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
            txt2.setHint(titleText);
        }
    }

    public void setTitleText3(String titleText) {
        if (titleText != null) {
            this.titleText2 = titleText;
            btn1.setText(titleText);
        }
    }




    public void setDataList(String title1,String[] d1){
        datalist = d1;
        title = title1;
    }


    public CustomItemA3p1(Context context) {
        this(context, null);
    }

    public CustomItemA3p1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomItemA3p1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(final Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.custom_item_a3p1, this, true);
        txt = (TextView) mView.findViewById(R.id.textView27);
        btn1 = mView.findViewById(R.id.button39);
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.CustomItem1Attr);
        setTitleText(a.getString(R.styleable.CustomItem1Attr_txt1));
        btn1.setText((a.getString(R.styleable.CustomItem1Attr_btn1)));
        LinearLayout as = mView.findViewById(R.id.as);
        as.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick1();

            }
        });
        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick1();
            }
        });
    }

    private void onclick1(){
        if(title==null||datalist==null||datalist.length==0){
            return;
        }
        final Context c1 = mContext;
        AlertDialog.Builder builder = new AlertDialog.Builder(c1);
        builder.setTitle(title);
        builder.setCancelable(true);
        builder.setIcon(R.mipmap.ic_launcher)
                .setItems(datalist, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setTitleText3(datalist[which]);
                    }
                }).create()
                .show();
    }

    public void setViewOnlickListener(OnClickListener onlickListener) {
        this.onClickListener = onlickListener;
        mView.setOnClickListener(onlickListener);
    }

}
