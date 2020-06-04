package com.example.administrator.new_ptns.my_utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitmapUtils {



    /*绘制位图*/
    public static Bitmap drawIntoBitmap(Bitmap bm) {
        float x = bm.getWidth();
        float y = bm.getHeight();
        Canvas c = new Canvas(bm);
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setAlpha(0x80);
        c.drawCircle(x/2, y/2, x/2, p);

        p.setAlpha(0x80);
        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        p.setTextSize(60);
        p.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fm = p.getFontMetrics();
        c.drawText("Alpha", x/2, y/2-fm.ascent/2, p);   //"Alpha"字符串在绘制的圆形中的文字
        return bm;
    }


    public static Bitmap drawText2Bitmap(String text, int imgResourceId, Context mContext) {
        try {
            Resources resources = mContext.getResources();
            float scale = resources.getDisplayMetrics().density;
            Bitmap bitmap = BitmapFactory.decodeResource(resources, imgResourceId);

            android.graphics.Bitmap.Config bitmapConfig = bitmap.getConfig();
            // set default bitmap config if none
            if (bitmapConfig == null) bitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
            // resource bitmaps are imutable, so we need to convert it to mutable one
            bitmap = bitmap.copy(bitmapConfig, true);

            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG); // new antialised Paint
            paint.setColor(Color.rgb(110, 110, 110));       // text color - #3D3D3D
            paint.setTextSize((int)(12 * scale));           // text size in pixels
            paint.setShadowLayer(1f, 0f, 1f, Color.DKGRAY); // text shadow

            // draw text to the Canvas center
            Rect bounds = new Rect();
            paint.getTextBounds(text, 0, text.length(), bounds);
            int x = (bitmap.getWidth() - bounds.width()) / 6;
            int y = (bitmap.getHeight() + bounds.height()) / 5;

            canvas.drawText(text, x * scale, y * scale, paint);
            return bitmap;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 保存图片到手机相册，并通知图库更新
     * @param context
     * @param bmp 图片bitmap
     * @return  返回图片保存的路径，开发人员可以根据返回的路径在手机里面查看，部分手机发送通知图库并不会更新
     */

    public static String saveImageToGallery(Context context, Bitmap bmp) {
        // 首先保存图片
        String galleryPath = Environment.getExternalStorageDirectory()+ File.separator+ "VideoRecorder";
        File dir = new File(galleryPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String path1 = dir.getAbsolutePath();



        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(path1, fileName);

        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        String path = path1+"/" + fileName;

        File f=new File(path);
        int fff = 12;
        if(!f.exists())
        {
            fff = -12;
        }else{
            fff = 12;
        }


        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + path)));
        return path;
    }


    private static File mPhotoFile = null;
    public static void setPhotoFile(File photoFile){
        mPhotoFile = photoFile;
    }

    public static File getPhotoFile(){

        return mPhotoFile;
    }

    /**
     * @param bmp 获取的bitmap数据
     * @param picName 自定义的图片名
     */
    public static void saveBmp2Gallery(Context context,Bitmap bmp, String picName) {
//        saveImageToGallery(bmp,picName);
        String fileName = null;
        //系统相册目录
        String galleryPath = Environment.getExternalStorageDirectory()+ File.separator+ "VideoRecorder";
//                + File.separator + "yingtan" + File.separator;


        File dir = new File(galleryPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String path1 = dir.getAbsolutePath();
        String path2 = path1+"/"+"fdd.mp4";

        File file = null;
        // 声明输出流
        FileOutputStream outStream = null;
        try {
            // 如果有目标文件，直接获得文件对象，否则创建一个以filename为名称的文件
            file = new File(path1, picName + ".jpg");
//            file = new File(galleryPath, photoName);
            // 获得文件相对路径
            fileName = file.toString();
            // 获得输出流，如果文件中有内容，追加内容
            outStream = new FileOutputStream(fileName);
            if (null != outStream) {
                bmp.compress(Bitmap.CompressFormat.JPEG, 90, outStream);
            }
        }catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                if (outStream != null) {
                    outStream.close();
                    setPhotoFile(file);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
//            MediaStore.Images.Media.insertImage(context.getContentResolver(),file.getAbsolutePath(),fileName,null);
            MediaStore.Images.Media.insertImage(context.getContentResolver(),bmp,fileName,null);
            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri uri = Uri.fromFile(file);
            intent.setData(uri);
            context.sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
