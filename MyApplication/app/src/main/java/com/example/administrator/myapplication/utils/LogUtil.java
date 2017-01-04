package com.example.administrator.myapplication.utils;

import android.util.Log;

/**
 * @author yy
 * @describle Logcat统一管理类
 * @time 2016/10/9 12:05
 */
public class LogUtil {

    private LogUtil() {
            /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static final String TAG = "mio";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (Constant.isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (Constant.isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (Constant.isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (Constant.isDebug)
            Log.v(TAG, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (Constant.isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (Constant.isDebug)
            Log.d(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (Constant.isDebug)
            Log.e(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (Constant.isDebug)
            Log.v(tag, msg);
    }

}
