package com.example.administrator.myapplication.activity.okgo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.api.BaseActivity;
import com.example.administrator.myapplication.model.NewsList;
import com.example.administrator.myapplication.p.BasePresenter;
import com.example.administrator.myapplication.p.INewsView;
import com.example.administrator.myapplication.p.NewsPresenter;
import com.example.administrator.myapplication.utils.ImageUtils;
import com.example.administrator.myapplication.utils.MD5;
import com.example.administrator.myapplication.view.TitleView;

import java.util.List;

/**
 * Created on 2017/1/4.
 * Author：yy
 * Description:okgo
 */


public class OkgoActivity extends BaseActivity<INewsView, NewsPresenter> implements INewsView {
    private static final String TAG = "OkgoActivity";
    private ProgressBar mProgressBar;
    private NewsPresenter mPresenter;
    private TitleView titleView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okgo);
        titleView = (TitleView) findViewById(R.id.okgo_title);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        titleView.setLeftIcon(R.mipmap.fanhui);
        titleView.setCenterText("okgo框架");
        titleView.setLeftIvListener(new TitleView.LeftIvClickListener() {
            @Override
            public void click(View view) {
                finish();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.load_data(1);
    }

    @Override
    public NewsPresenter initPresenter() {
        mPresenter = new NewsPresenter(OkgoActivity.this);  //调用接口的实现
        return mPresenter;
    }

    @Override
    public void get_lv_data(List<NewsList> data) {
        Log.i(TAG, "data activity:" + data);
        String url = MD5.geturl(data.get(0).getCover());
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }
}
