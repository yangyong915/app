package com.example.administrator.myapplication.activity.mio;

import android.support.v4.app.Fragment;

/**
 * Created on 2017/1/17.
 * Author：yy
 * Description:功能描述
 */


public class DrawerFragment extends Fragment {
    protected MyDrawerListener myDrawerListener;

    public void setOnDrawListener(MyDrawerListener listener) {
        this.myDrawerListener = listener;
    }
}
