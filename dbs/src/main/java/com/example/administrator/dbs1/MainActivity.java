package com.example.administrator.dbs1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.dbs1.ble.BLEManager;
import com.example.administrator.dbs1.my_utils.PermissionUtils;
import com.example.administrator.dbs1.pager.MyPagerAdapter;
import com.example.administrator.dbs1.pager.user.PagerUserItem;
import com.example.administrator.dbs1.pager.user.UserDao;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private int[] drawableIds = new int[] {R.mipmap.me, R.mipmap.timing, R.mipmap.main,
            R.mipmap.template};
    private List<View> viewList = new ArrayList<>();
    private ViewPager viewPager;
    private List<Integer> drawableList;

    ImageView iv_main,iv_template,iv_timing,iv_me;
    LinearLayout ll_main,ll_template,ll_timing,ll_me;

    BLEManager bleManager;
    MyPagerAdapter myPagerAdapter;
    private Boolean ble_flag = false;
    public PagerUserItem current_user = null;
    int start_page = 0;
    ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        init_ui_and_uievent();

        if(ble_flag) {
            bleManager = new BLEManager(this, new BLEManager.MyCallbackInterface() {
                public void onBleReturnValue(byte[] values) {
                    onBleReturnValue(values);
                }
            });
            bleManager.onCreate();
        }
        UserDao dao = new UserDao(this);
        //dao.delete_all();
        ArrayList<PagerUserItem> list1 = dao.getAllUsers();
        if(list1.size()==0){
            current_user = null;
        }else{
            current_user = list1.get(0);
        }
        //PermissionUtils.requestPermission(this, PermissionUtils.CODE_WRITE_EXTERNAL_STORAGE, onStorageFine);
        //PermissionUtils.requestPermission(this, PermissionUtils.CODE_CAMERA, onStorageFine);
        set_page(2);

//        HistoryDao historyDao = new HistoryDao(this);
//        historyDao.delete_all();
//        ArrayList<HistoryData> historyDatas = HistoryData.get_simulation_datas();
//        for(int i = 0 ; i < historyDatas.size();i++){
//            historyDao.insert(historyDatas.get(i));
//        }


    }




    public PermissionUtils.PermissionGrant onStorageFine = new PermissionUtils.PermissionGrant() {
        @Override
        public void onPermissionGranted(int requestCode) {
            switch (requestCode) {
                case PermissionUtils.CODE_WRITE_EXTERNAL_STORAGE:
                    break;
                case PermissionUtils.CODE_CAMERA:

                    break;
                default:
                    break;
            }
        }
    };





    public void onBleReturnValue(byte[] values){
//        switch (values[2]){
//            case CMD_code.CMD_BATTERY_MEASURE:
//                break;
//
//        }
    }


    public void write_with_read(int[] values){
        bleManager.write_with_read(values);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(ble_flag) {
            bleManager.onResume();
        }
       myPagerAdapter.onResume(viewPager.getCurrentItem());
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(ble_flag) {
            bleManager.onPause();
        }
    }

    private void init_ui_and_uievent(){
        myPagerAdapter = new MyPagerAdapter(MainActivity.this, viewList, drawableList);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                set_page(i);
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        viewPager.setVisibility(View.INVISIBLE);
        viewPager.postDelayed(new Runnable() {

            @Override
            public void run() {
                viewPager.setVisibility(View.VISIBLE);
                // 设置初始 position
                set_page(start_page);
            }
        }, 100);

        iv_main = (ImageView)findViewById(R.id.iv_main);
        iv_template = (ImageView)findViewById(R.id.iv_template);
        iv_timing = (ImageView)findViewById(R.id.iv_timing);
        iv_me = (ImageView)findViewById(R.id.iv_me);

        ll_main = (LinearLayout) findViewById(R.id.ll_main);
        ll_template = (LinearLayout)findViewById(R.id.ll_template);
        ll_timing = (LinearLayout)findViewById(R.id.ll_timing);
        ll_me = (LinearLayout)findViewById(R.id.ll_me);

        drawableList = new ArrayList<Integer>();
        drawableList.add(drawableIds[drawableIds.length - 1]);
        for (int id : drawableIds) {
            drawableList.add(id);
        }
        drawableList.add(drawableIds[0]);

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.viewpager_item1, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.viewpager_item2, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.viewpager_item3, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.viewpager_item4, null);
        viewList.add(view);

        ll_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_page(0);
            }
        });
        ll_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_page(3);
            }
        });
        ll_template.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_page(1);
            }
        });
        ll_timing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_page(2);
            }
        });
        viewPager.setAdapter(myPagerAdapter);
    }

    private void set_page(int i){
        fresh_bottom();
        if(i==0){
            iv_main.setImageResource(R.mipmap.main);
            viewPager.setCurrentItem(0, false);
        }
        if(i==1){
            iv_template.setImageResource(R.mipmap.template);
            viewPager.setCurrentItem(1, false);
        }
        if(i==2){
            iv_timing.setImageResource(R.mipmap.timing);
            viewPager.setCurrentItem(2, false);
        }
        if(i==3){
            iv_me.setImageResource(R.mipmap.me);
            viewPager.setCurrentItem(3, false);
        }
    }



    private void fresh_bottom(){
        iv_me.setImageResource(R.mipmap.me_grey);
        iv_timing.setImageResource(R.mipmap.timing_grey);
        iv_template.setImageResource(R.mipmap.template_grey);
        iv_main.setImageResource(R.mipmap.main_grey);
    }










    public static final int CODE_PERMISSION_IMAGE = 1;
    public static final int CODE_PERMISSION_VIDEO = 2;
    @Override
    protected void onPermissionGranted(int code) {
        switch (code) {
            case CODE_PERMISSION_IMAGE: {
                Toast.makeText(MainActivity.this,"image ok",Toast.LENGTH_LONG).show();
                break;
            }
            case CODE_PERMISSION_VIDEO: {
                //Toast.makeText(MainActivity.this,"video ok",Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(this, CameraActivity.class));
                break;
            }
            default: {
                throw new AssertionError("This should not be the case.");
            }
        }
    }

    @Override
    protected void onPermissionDenied(int code) {
        int messageRes;
        switch (code) {
            case CODE_PERMISSION_IMAGE: {
                messageRes = com.yanzhenjie.album.R.string.album_permission_camera_image_failed_hint;
                break;
            }
            case CODE_PERMISSION_VIDEO: {
                messageRes = com.yanzhenjie.album.R.string.album_permission_camera_video_failed_hint;

                break;
            }
            default: {
                throw new AssertionError("This should not be the case.");
            }
        }
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(com.yanzhenjie.album.R.string.album_title_permission_failed)
                .setMessage(messageRes)
                .setPositiveButton(com.yanzhenjie.album.R.string.album_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callbackCancel();
                    }
                })
                .show();
    }

    private void callbackResult() {
//        if (sResult != null) sResult.onAction(mCameraFilePath);
//        sResult = null;
//        sCancel = null;
       // finish();
    }

    private void callbackCancel() {
//        if (sCancel != null) sCancel.onAction("User canceled.");
//        sResult = null;
//        sCancel = null;
       // finish();
    }
}

