/*
 * Copyright 2017 Yan Zhenjie.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.administrator.new_ptns;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.example.administrator.new_ptns.ble.BLEManager;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;

/**
 * Created by YanZhenjie on 2017/8/17.
 */
public class PlayMediaActivity extends AppCompatActivity {

    TextView mTextView;
    private ImageView mImageView;
    private TextureView textureView;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_media);

        mImageView = findViewById(R.id.image_view);
        textureView = findViewById(R.id.sdfsdf);
        pref = this.getSharedPreferences(BLEManager.BLE_PREF, this.MODE_PRIVATE);
        editor = pref.edit();
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        String value = intent.getStringExtra("value");
        if(type==""){
            return;
        }
        if(type=="picture"){
            play_picture(value);
        }else{
            playVideo(value);
        }
    }

    private void play_picture(String path){}


    private MediaPlayer mMediaPlayer;
    private void playVideo(String videoPath){

        try {
            if(mMediaPlayer != null){
                mMediaPlayer.stop();
                mMediaPlayer.release();
                mMediaPlayer = null;
            }

            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDataSource(videoPath);

            //mMediaPlayer.setSurface(new Surface(textureView.getSurfaceTexture()));
            mMediaPlayer.setLooping(true);
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();

                    float ratio = mp.getVideoWidth()*1f/mp.getVideoHeight();
                    int width = textureView.getWidth();
                    ViewGroup.LayoutParams layoutParams = textureView.getLayoutParams();
                    layoutParams.height = (int) (width/ratio);
                    textureView.setLayoutParams(layoutParams);
                }
            });
            mMediaPlayer.prepareAsync();
        }catch (Exception e){
            e.printStackTrace();
        }
    }





}
