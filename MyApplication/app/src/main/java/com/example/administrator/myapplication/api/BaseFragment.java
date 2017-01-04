package com.example.administrator.myapplication.api;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.administrator.myapplication.p.BasePresenter;

/**
 * fragment基类
 */
public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment {

    public T presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        presenter = initPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
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
