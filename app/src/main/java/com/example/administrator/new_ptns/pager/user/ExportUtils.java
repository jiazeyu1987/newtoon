package com.example.administrator.new_ptns.pager.user;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.administrator.new_ptns.MainActivity;

public class ExportUtils {
    DataExportActivity mContext = null;
    public ExportUtils(DataExportActivity main){
        mContext = main;
    }

    public void doExport(){

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
}
