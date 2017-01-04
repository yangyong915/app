package com.example.administrator.myapplication.api;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.myapplication.p.BasePresenter;

/**
 * Created on 2017/1/4.
 * Author：yy
 * Description:activity 基类
 */


public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {
    public T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView((V) this);
    }

    @Override
    public void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    // 实例化presenter
    public abstract T initPresenter();
}
