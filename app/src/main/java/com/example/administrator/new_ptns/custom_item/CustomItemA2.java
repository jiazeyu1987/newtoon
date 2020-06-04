package com.example.administrator.new_ptns.custom_item;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.util.TimeUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.new_ptns.R;

import java.util.Calendar;


/**
 * Created by tianxiying on 2018/3/1.
 */

public class CustomItemA2 extends LinearLayout {
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
    private boolean clickable = true;
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

    public void setValue3(String titleText) {
        if (titleText != null) {
            txt2.setText(titleText);
        }
    }

    public String getTitleText3() {
        return txt2.getText().toString();
    }

    public void setUnClickableValue(String titleText) {
        txt2.setText(titleText);
        clickable  = false;
    }




    public void setDataList(String title1,String[] d1){
        datalist = d1;
        title = title1;
        mView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(title==null||datalist==null||datalist.length==0){
                    return;
                }
                if(!clickable){
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
                                txt2.setText(datalist[which]);
                            }
                        }).create()
                        .show();

            }
        });
    }


    public void setDatePicker(){
        mView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
                final int mYear = c.get(Calendar.YEAR);
                final int mMonth = c.get(Calendar.MONTH)+1;
                final int mDay = c.get(Calendar.DATE);
                DatePickerDialog datePickerDialog = new DatePickerDialog(mContext, DatePickerDialog.THEME_HOLO_DARK,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                String s2 = year+"-"+month+"-"+dayOfMonth;
                                txt2.setText(s2);
                            }
                        },
                        mYear, mMonth-1, mDay);
                datePickerDialog.show();
            }
        });

    }

    public CustomItemA2(Context context) {
        this(context, null);
    }

    public CustomItemA2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomItemA2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(final Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.custom_item_a3, this, true);
        txt = (TextView) mView.findViewById(R.id.textView27);
        txt2 = mView.findViewById(R.id.textView89);
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.CustomItem1Attr);
        setTitleText(a.getString(R.styleable.CustomItem1Attr_txt1));

    }


    public void setViewOnlickListener(OnClickListener onlickListener) {
        this.onClickListener = onlickListener;
        mView.setOnClickListener(onlickListener);
    }

}
