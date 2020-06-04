package com.example.administrator.new_ptns;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ToastUtils;
import com.example.administrator.new_ptns.ble.BLEManager;
import com.example.administrator.new_ptns.custom_item.CustomItemA1;
import com.example.administrator.new_ptns.data_handler.ContactDao;
import com.example.administrator.new_ptns.data_handler.OperationTempDataDao;
import com.example.administrator.new_ptns.data_handler.PatientDao;
import com.example.administrator.new_ptns.my_utils.TimeUtils;
import com.example.administrator.new_ptns.pager.MyPagerAdapter;
import com.example.administrator.new_ptns.pager.shuqian.AddressPickTask;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumConfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;


public class MainActivity extends Title3Activity
{

    public CustomItemA1 ci1_name;
    @BindView(R.id.button28)
    public Button shuqian;
    @BindView(R.id.button29)
    public Button shuzhong;
    @BindView(R.id.button26)
    public Button debug;
    @BindView(R.id.button27)
    public Button patient_info;
    @BindView(R.id.vp1)
    public ViewPager viewPager;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    public MyPagerAdapter myPagerAdapter;
    private List<View> viewList = new ArrayList<>();
    LinearLayout testlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nt_main);

        ButterKnife.bind(this);
        init_view();
        G.init(TimeUtils.getCurrentTimeYMD2(),TimeUtils.DayofWeek());
        init_title();
        //ContactDao dao = new ContactDao(this);
        ////dao.delete_all();
        Album.initialize(AlbumConfig.newBuilder(this)
                .setAlbumLoader(new MediaLoader())
                .setLocale(Locale.getDefault())
                .build()
        );
        //test_camera();

    }

    private void test_camera(){
        pref = this.getSharedPreferences(BLEManager.BLE_PREF, this.MODE_PRIVATE);
        editor = pref.edit();
        testlayout = findViewById(R.id.fa);
        testlayout.setVisibility(View.VISIBLE);
        viewPager.setVisibility(View.INVISIBLE);
        final String s1 = pref.getString("pic","fff");

        ArrayList<String> pathlist = new ArrayList<>();
        pathlist.add(s1);
        for (int i = 0; i < 1; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(500, 500));  //设置图片宽高
//            //imageView.setImageResource(R.mipmap.dianliu); //图片资源
//            try {
//                FileInputStream fis = new FileInputStream(s1);
//                Bitmap bmp = BitmapFactory.decodeStream(fis);  ///把流转化为Bitmap图片
//                imageView.setImageBitmap(bmp);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
            testlayout.addView(imageView); //动态添加图片
            Album.getAlbumConfig()
                    .getAlbumLoader()
                    .load(imageView, s1);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUtils.showLong(s1);
                }
            });
        }
        final String s2 = pref.getString("camera","fff");
        for (int i = 0; i < 1; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(500, 500));
            testlayout.addView(imageView); //动态添加图片
            Album.getAlbumConfig()
                    .getAlbumLoader()
                    .load(imageView, s2);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUtils.showLong(s2);
                    Intent intent = new Intent(MainActivity.this,PlayMediaActivity.class);
                    intent.putExtra("type","video");
                    intent.putExtra("value",s2);
//                    startActivity(intent);
                }
            });
        }

    }


    private void init_view(){
        shuqian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_click_shuqian();
            }
        });

        shuzhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_click_shuzhong();
            }
        });

        debug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_click_debug();
            }
        });

        patient_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_click_patient_info();
            }
        });


        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.pager_nt_main_1, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.pager_nt_main_2, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.pager_nt_main_3, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.pager_nt_main_4, null);
        viewList.add(view);

        myPagerAdapter = new MyPagerAdapter(MainActivity.this, viewList, null);
        viewPager.setAdapter(myPagerAdapter);

        if(G.TEST){
           // shuzhong.performClick();
        }

        Intent intent = getIntent();
        G.doctor_id = intent.getIntExtra("doctor_id",1);
        //after setting doctor id
        PatientDao dao = new PatientDao(this);
        G.patientDataArrayList = dao.get_patient_by_doctor_id(G.doctor_id);
        OperationTempDataDao operationTempDataDao = new OperationTempDataDao(this);
        operationTempDataDao.delete_all();
    }

    private void do_click_shuqian(){
        set_choosen(shuqian);
        viewPager.setCurrentItem(0, false);
    }

    private void do_click_shuzhong(){
        set_choosen(shuzhong);
        viewPager.setCurrentItem(1, false);
    }

    private void do_click_debug(){
        set_choosen(debug);
        viewPager.setCurrentItem(2, false);



    }

    private void do_click_patient_info(){
        set_choosen(patient_info);
        viewPager.setCurrentItem(3, false);
    }



    private void set_choosen(Button button){
        shuqian.setBackgroundColor(getResources().getColor(R.color.white));
        shuzhong.setBackgroundColor(getResources().getColor(R.color.white));
        debug.setBackgroundColor(getResources().getColor(R.color.white));
        patient_info.setBackgroundColor(getResources().getColor(R.color.white));
        button.setBackgroundColor(getResources().getColor(R.color.green2));
    }

}

