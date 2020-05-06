package com.example.administrator.new_ptns.pager.treatment;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.administrator.new_ptns.CameraActivity;
import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.chart.ChartManagerActivity;
import com.example.administrator.new_ptns.my_utils.BitmapUtils;
import com.example.administrator.new_ptns.my_utils.PermissionUtils;
import com.example.administrator.new_ptns.pager.PagerBase;
import com.example.administrator.new_ptns.pager.template.PagerTemplateItem;
import com.example.administrator.new_ptns.pager.template.TemplateDao;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class PagerTreatment extends PagerBase {

    LinearLayout treatment_template,treatment_time;
    TextView tv_template,tv_time,tv_current,tv_hour,tv_min,tv_second;
    int stim_time;
    int count_time;
    int current = 0;
    ImageView btn_add,btn_minus,export;
    LinearLayout btn_history;
    public PagerTreatment(MainActivity context){
        super(context);
    }

    @Override
    public void init_view(View view,String type){
        super.init_view(view,type);
        treatment_template = mView.findViewById(R.id.treatment_template);
        treatment_template.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_show_treatment_template();
            }
        });

        export = mView.findViewById(R.id.imageView20);
        export.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bitmap bitmap = setTextToImg("我是绘制上来的");
//                BitmapUtils.saveImageToGallery(mContext,bitmap);
                //mContext.startActivity(new Intent(mContext, CameraActivity.class));
//                mContext.requestPermission(MainActivity.PERMISSION_TAKE_VIDEO, MainActivity.CODE_PERMISSION_VIDEO);

            }
        });

        treatment_time = mView.findViewById(R.id.treatment_time);
        treatment_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_show_treatment_time();
            }
        });
        tv_template = mView.findViewById(R.id.asas2);
        tv_current = mView.findViewById(R.id.textView11);
        tv_time = mView.findViewById(R.id.asas);

        tv_hour = mView.findViewById(R.id.textView20);
        tv_min = mView.findViewById(R.id.textView22);
        tv_second = mView.findViewById(R.id.textView24);

        btn_add = mView.findViewById(R.id.imageView7);
        btn_minus = mView.findViewById(R.id.imageView8);
        btn_history = mView.findViewById(R.id.sdfsdf);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_add_current();
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_minus_current();
            }
        });
        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_enter_history();
            }
        });
        //do_enter_history();
        //test();
    }

    /**
     * 文字绘制在图片上，并返回bitmap对象
     */
    private Bitmap setTextToImg(String text) {

        Bitmap bitmap = Bitmap.createBitmap( 1000, 8080, Bitmap.Config.ARGB_8888 );//创建一个新百的和度SRC长度宽度问一样的位图
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        // 抗锯齿
        paint.setAntiAlias(true);
        // 防抖动
        paint.setDither(true);
        paint.setTextSize(30);
        paint.setColor(Color.parseColor("#aaee00"));
        for(int i = 0 ; i < 600;i++) {
            canvas.drawText(text, 10, 10+40*i, paint);
        }
        return bitmap;
    }



    private void test(){
//        PermissionUtils.requestPermission(mContext, PermissionUtils.CODE_WRITE_EXTERNAL_STORAGE, mContext.onStorageFine);
//        PermissionUtils.requestPermission(mContext, PermissionUtils.CODE_CAMERA, mContext.onStorageFine);
//        Bitmap mBitmap1 = Bitmap.createBitmap(200, 200, Bitmap.Config.ALPHA_8);
//        mBitmap1 = BitmapUtils.drawIntoBitmap(mBitmap1);
//        BitmapUtils.drawText2Bitmap("123",R.drawable.d321,mContext);
//        BitmapUtils.saveImageToGallery(mContext,mBitmap1);
    }

    private void do_enter_history(){
        Intent intent =  new Intent(mContext, ChartManagerActivity.class);
        mContext.startActivity(intent);
    }

    private void do_add_current(){
        if(current>900){
            return;
        }
        current+=100;
        fresh_current();
    }
    private void do_minus_current(){
        if(current<100){
            return;
        }
        current-=100;
        fresh_current();
    }

    private void fresh_current(){
        tv_current.setText(current*1.0/1000+"");
    }

    private void do_show_treatment_template(){
        TemplateDao dao = new TemplateDao(mContext);
        ArrayList<PagerTemplateItem> list2 = dao.getAllTemplates();
        ArrayList<String> liststring = new ArrayList<>();
        for(int i = 0 ; i < list2.size() ;i++){
            liststring.add(list2.get(i).name);
        }
        final String[] arra1 = liststring.toArray(new String[liststring.size()]);
        android.support.v7.app.AlertDialog.Builder builder1=new android.support.v7.app.AlertDialog.Builder(mContext);
        builder1.setTitle("请选择模板");
        builder1.setItems(arra1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv_template.setText(arra1[which]);
            }
        });
        builder1.show();
    }

    private void fresh_stim_time(){
        int hour2 = stim_time/3600;
        int min = (stim_time%3600)/60;
        String s1 = "";
        if(hour2>0){
            s1 = s1+hour2+"小时";
        }
        if(min>0){
            s1 = s1+min+"分钟";
        }
        tv_time.setText(s1);
    }

    private void fresh_count_time(){
        int hour2 = stim_time/3600;
        int min = (stim_time%3600)/60;
        int sec = (stim_time%60);
        tv_hour.setText(String.format("%02d", hour2));
        tv_min.setText(String.format("%02d", min));
        tv_second.setText(String.format("%02d", sec));
    }

    private void do_count(){
        stim_time-=1;
        fresh_count_time();
        if(stim_time<1){
            stop_timer();
        }
    }

    private void do_show_treatment_time(){

        new TimePickerDialog(mContext,2,new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if(hourOfDay*3600+minute*60>3600*4){
                    stim_time = 3600*4;
                }else{
                    stim_time = hourOfDay*3600+minute*60;
                };
                count_time = stim_time;
                fresh_stim_time();
                fresh_count_time();
                start_timer();
            }
        }, stim_time/3600, (stim_time%3600)/60, true).show();

    }

    public static final int TIMER_START = 1;
    public static final int TIMER_STOP = 0;
    public int timer_state = TIMER_STOP;
    TimerTask task;
    Timer timer = new Timer();
    private void start_timer(){
        if(timer_state==TIMER_START){
            return;
        }
        initTimer();
        timer.schedule(task,0,1000);
        timer_state = TIMER_START;
    }

    private void stop_timer(){
        if(timer_state == TIMER_STOP){
            return;
        }
        timer_state = TIMER_STOP;
        destroyTimer();
    }

    //初始化timer
    public void initTimer() {
        task = new TimerTask() {
            @Override
            public void run() {
                try {
                    Message m = new Message();
                    m.what=1;
                    handler.sendMessage(m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer = new Timer();
    }

    Handler handler = new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    do_count();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    public void destroyTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (task != null) {
            task.cancel();
            task = null;
        }
    }
}
