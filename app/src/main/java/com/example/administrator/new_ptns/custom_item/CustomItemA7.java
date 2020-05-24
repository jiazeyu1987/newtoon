package com.example.administrator.new_ptns.custom_item;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.data_handler.SolutionData;


/**
 * Created by tianxiying on 2018/3/1.
 */

public class CustomItemA7 extends LinearLayout {
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
    ConstraintLayout title_layout;
    CustomItemA3p2 test_time,starttime,endtime;
    CustomItemA5 bundle_pulse,bundle_freq,bundle_range;
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

    public void update_vcmode(String vc){
        bundle_range.update_vcmode(vc);
    }

    public void setTitleText2(String titleText) {
        if (titleText != null) {
            this.titleText2 = titleText;
            txt2.setText(titleText);
        }
    }

    public void setMode1(){
        title_layout.setVisibility(INVISIBLE);
    }
    public void setMode2(){
        title_layout.setVisibility(VISIBLE);
    }


    public void setDataList(String title1,String[] d1){
        datalist = d1;
        title = title1;
    }

    public SolutionData getSolutionData(){
        return new SolutionData(starttime.btn1.getText().toString(),
                endtime.btn1.getText().toString(),
                bundle_range.getTitleText2(),
                bundle_freq.getTitleText2(),
                bundle_pulse.getTitleText2(),
                test_time.btn1.getText().toString(),bundle_range.vc_mode);
    }

    public void setSolutionData(SolutionData solutionData){
        Log.e("111",starttime.toString());
        Log.e("111",starttime.btn1.toString());
        starttime.btn1.setText(solutionData.start_time);
        endtime.btn1.setText(solutionData.end_time);
        test_time.btn1.setText(solutionData.test_time);
        bundle_range.setTitleText2(solutionData.range);
        bundle_freq.setTitleText2(solutionData.freq);
        bundle_pulse.setTitleText2(solutionData.pulse);
    }

    public CustomItemA7(Context context) {
        this(context, null);
    }

    public CustomItemA7(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomItemA7(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(final Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.custom_item_a7, this, true);
        txt = (TextView) mView.findViewById(R.id.textView108);
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.CustomItem1Attr);
        setTitleText(a.getString(R.styleable.CustomItem1Attr_txt1));

        test_time = mView.findViewById(R.id.ci_testtime);
        test_time.setDataList("请选择测试时间",new String[]{"5s","10s","30s","1min","手动"});

        bundle_range = mView.findViewById(R.id.adfadf);
        bundle_freq = mView.findViewById(R.id.customItemA54);
        bundle_pulse = mView.findViewById(R.id.customItemA55);

        title_layout = mView.findViewById(R.id.fadfadf);

        starttime = mView.findViewById(R.id.ci_starttime);
        endtime = mView.findViewById(R.id.ci_endtime);

    }


    public void setViewOnlickListener(OnClickListener onlickListener) {
        this.onClickListener = onlickListener;
        mView.setOnClickListener(onlickListener);
    }

}
