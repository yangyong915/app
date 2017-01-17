package com.example.administrator.myapplication.utils;

import android.app.Activity;
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

    public static void setImage(Activity activity, final ImageView img, String url) {
        OkGo.get(url)
                .tag(activity)
                .execute(new BitmapCallback() {
                    @Override
                    public void onSuccess(Bitmap bitmap, Call call, Response response) {
                        img.setImageBitmap(bitmap);
                    }
                });
    }
}
