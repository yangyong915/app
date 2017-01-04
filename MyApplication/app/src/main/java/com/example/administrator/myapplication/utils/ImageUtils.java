package com.example.administrator.myapplication.utils;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by yy on 2016/12/26.
 */

public class ImageUtils {

    public static void setImage(final ImageView img, String url) {
        OkGo.post(url)
                .execute(new BitmapCallback() {
                    @Override
                    public void onSuccess(Bitmap bitmap, Call call, Response response) {
                        Log.i("main", "success bitmap:" + bitmap);
                        img.setImageBitmap(bitmap);
                    }
                });
    }
}
