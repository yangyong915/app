package com.example.administrator.myapplication.p;

import android.content.Context;
import android.util.Log;

import com.example.administrator.myapplication.model.Base;
import com.example.administrator.myapplication.model.NewsList;
import com.example.administrator.myapplication.utils.AesUtil;
import com.example.administrator.myapplication.utils.Constant;
import com.example.administrator.myapplication.utils.MD5;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by yy on 2016/12/22.
 */

public class NewsPresenter extends BasePresenter<INewsView>{

    private static final String TAG = "NewsPresenter";
    private INewsView mINewsView;

    public NewsPresenter(INewsView newsView) {
        mINewsView = newsView;
    }

    public void load_data(int page) {
        mINewsView.showLoading();
        try {
            HashMap<String, Object> params = new HashMap<>();
            params.put("page", 1);
            params.put("nonce_str", MD5.getMessageDigest(String.valueOf(System.currentTimeMillis()).getBytes()));
            JSONObject jsonObject = new JSONObject(params);
            Log.i(TAG, "req:" + jsonObject.toString());
            String param = AesUtil.encrypt(jsonObject.toString());

            OkGo.post(Constant.GET_NEWSLIST)
                    .tag(this)
                    .params("data", param)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            try {
                                s = AesUtil.desEncrypt(s);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Log.i(TAG, "data:" + s);
                            Gson gson = new Gson();
                            Base<List<NewsList>> data = gson.fromJson(s,
                                    new TypeToken<Base<List<NewsList>>>() {
                                    }.getType());
                            mINewsView.get_lv_data(data.getData());
                            mINewsView.hideLoading();
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            mINewsView.hideLoading();
                            Log.i(TAG, "error:" + response.toString());
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
