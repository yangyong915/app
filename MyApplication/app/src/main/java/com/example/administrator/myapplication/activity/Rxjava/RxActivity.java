package com.example.administrator.myapplication.activity.Rxjava;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.model.Base;
import com.example.administrator.myapplication.model.NewsList;
import com.example.administrator.myapplication.utils.AesUtil;
import com.example.administrator.myapplication.utils.Constant;
import com.example.administrator.myapplication.utils.MD5;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxActivity extends BaseRxActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rx_text)
    TextView rxText;
    @BindView(R.id.content_rx)
    RelativeLayout contentRx;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        get_data();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unSubscribe();
    }

    public void get_data() {
        try {
            HashMap<String, Object> params = new HashMap<>();
            params.put("page", 1);
            params.put("nonce_str", MD5.getMessageDigest(String.valueOf(System.currentTimeMillis()).getBytes()));
            JSONObject jsonObject = new JSONObject(params);
            String param = AesUtil.encrypt(jsonObject.toString());
            Subscription subscription = OkGo.post(Constant.GET_NEWSLIST)
                    .tag(this)
                    .params("data", param)
                    .getCall(StringConvert.create(), RxAdapter.<String>create())
                    .doOnSubscribe(new Action0() {
                        @Override
                        public void call() {

                        }
                    })
                    .map(new Func1<String, String>() {

                        @Override
                        public String call(String s) {
                            return s;
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())   //切换到主线程
                    .subscribe(new Action1<String>() {
                        @Override
                        public void call(String s) {
                            try {
                                s = AesUtil.desEncrypt(s);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Log.i("rxjava test", "data:" + s);
                            Gson gson = new Gson();
                            Base<List<NewsList>> data = gson.fromJson(s,
                                    new TypeToken<Base<List<NewsList>>>() {
                                    }.getType());
                            rxText.setText(data.getData().get(0) + "----\n" + data.getData().get(1));
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {

                        }
                    });

            addSubscribe(subscription);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
