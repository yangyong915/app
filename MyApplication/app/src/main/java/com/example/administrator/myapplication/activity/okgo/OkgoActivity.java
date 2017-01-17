package com.example.administrator.myapplication.activity.okgo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.api.BaseActivity;
import com.example.administrator.myapplication.model.NewsList;
import com.example.administrator.myapplication.p.INewsView;
import com.example.administrator.myapplication.p.NewsPresenter;
import com.example.administrator.myapplication.utils.ImageUtils;
import com.example.administrator.myapplication.utils.MD5;
import com.example.administrator.myapplication.view.TitleView;
import com.lzy.okgo.OkGo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created on 2017/1/4.
 * Author：yy
 * Description:okgo
 */


public class OkgoActivity extends BaseActivity<INewsView, NewsPresenter> implements INewsView {
    private static final String TAG = "OkgoActivity";
    @BindView(R.id.okgo_title)
    TitleView okgoTitle;
    @BindView(R.id.okgo_text)
    TextView okgoText;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.activity_si_xin)
    RelativeLayout activitySiXin;
    @BindView(R.id.okgo_img)
    ImageView okgoImg;

    private NewsPresenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okgo);
        ButterKnife.bind(this);

        get_title();
    }

    private void get_title() {
        okgoTitle.setLeftIcon(R.mipmap.fanhui);
        okgoTitle.setCenterText("okgo框架");
        okgoTitle.setLeftIvListener(new TitleView.LeftIvClickListener() {
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
        okgoText.setText("" + data.get(0).toString());
        String url = MD5.geturl(data.get(0).getCover());
        Log.i(TAG, "okgo_url:" + url);
        //请求图片
        ImageUtils.setImage(OkgoActivity.this, okgoImg, url);
    }

    @Override
    public void showLoading() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //Activity销毁时，取消网络请求
        OkGo.getInstance().cancelTag(this);
    }
}
