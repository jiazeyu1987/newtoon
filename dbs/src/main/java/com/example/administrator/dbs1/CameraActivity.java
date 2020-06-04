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
package com.example.administrator.dbs1;

import android.content.Intent;
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

import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;

/**
 * Created by YanZhenjie on 2017/8/17.
 */
public class CameraActivity extends AppCompatActivity {

    TextView mTextView;
    private ImageView mImageView;
    private TextureView textureView;
    Button btn_pic,btn_video;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        mTextView = findViewById(R.id.tv_message);
        mImageView = findViewById(R.id.image_view);
        textureView = findViewById(R.id.sdfsdf);
        btn_pic = findViewById(R.id.button6);
        btn_video = findViewById(R.id.button8);

        btn_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });

        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordVideo();
            }
        });
    }

    private void takePicture() {
        Album.camera(this)
                .image()
//                .filePath()
                .onResult(new Action<String>() {
                    @Override
                    public void onAction(@NonNull String result) {
                        mTextView.setText(result);
                        CameraActivity.this.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + result)));
                        Album.getAlbumConfig()
                                .getAlbumLoader()
                                .load(mImageView, result);
                    }
                })
                .onCancel(new Action<String>() {
                    @Override
                    public void onAction(@NonNull String result) {
                        Toast.makeText(CameraActivity.this, "cancel", Toast.LENGTH_LONG).show();
                    }
                })
                .start();
    }

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
            mMediaPlayer.setSurface(new Surface(textureView.getSurfaceTexture()));
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


    private void recordVideo() {
        Album.camera(this)
                .video()
//                .filePath()
                .quality(1)
                .limitDuration(Integer.MAX_VALUE)
                .limitBytes(Integer.MAX_VALUE)
                .onResult(new Action<String>() {
                    @Override
                    public void onAction(@NonNull String result) {
                        mTextView.setText(result);
                        playVideo(result);
                        CameraActivity.this.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + result)));
                        Album.getAlbumConfig()
                                .getAlbumLoader()
                                .load(mImageView, result);
                    }
                })
                .onCancel(new Action<String>() {
                    @Override
                    public void onAction(@NonNull String result) {
                        Toast.makeText(CameraActivity.this,"cancel", Toast.LENGTH_LONG).show();
                    }
                })
                .start();
    }


}
