package com.example.administrator.myapplication.activity.webview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.MainActivity;
import com.example.administrator.myapplication.view.TitleView;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * Created on 2017/1/4.
 * Author：yy
 * Description:腾讯x5内核webview测试
 */


public class X5WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private TitleView titleView;
    private com.tencent.smtt.sdk.WebSettings webSettings;
    private ValueCallback<Uri> mUploadMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = (WebView) findViewById(R.id.webView);
        //webview属性配置，主要处理js调用问题
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBlockNetworkImage(false);//解决图片不显示
        // 自适应屏幕
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);
        webView.setWebChromeClient(new myChromeClient());
        webView.setWebViewClient(new myWebViewClient());
        webView.loadUrl("https://app-service.wopu.me/Extra.wp/News/getNewsContent?news_id=247");

        titleView = (TitleView) findViewById(R.id.webview_title);
        titleView.setLeftIcon(R.mipmap.fanhui);
        titleView.setLeftIvListener(new TitleView.LeftIvClickListener() {
            @Override
            public void click(View view) {
                webView.clearCache(true);
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    finish();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (null == mUploadMessage) {
            return;
        }
        if (resultCode == RESULT_OK && requestCode == 1) {   //网页调用系统相册
            Uri result = intent.getData();
            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;
        } else {
            mUploadMessage.onReceiveValue(null);
        }
    }

    class myWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //网页加载完成
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String s) {
            return super.shouldOverrideUrlLoading(webView, s); //是否就在次页面进行加载js链接，默认是
        }
    }

    class myChromeClient extends WebChromeClient {

        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }

        @Override
        public void onReceivedTitle(WebView webView, String s) {  //网页标题
            super.onReceivedTitle(webView, s);
            titleView.setCenterText(s);
        }

        // Android > 4.1.1 调用这个方法
        public void openFileChooser(ValueCallback<Uri> uploadMsg,
                                    String acceptType, String capture) {
            mUploadMessage = uploadMsg;
            choosePicture();
        }

        private void choosePicture() {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, 1);
        }

        // 3.0 + 调用这个方法
        public void openFileChooser(ValueCallback<Uri> uploadMsg,
                                    String acceptType) {
            mUploadMessage = uploadMsg;
            choosePicture();
        }

        // Android < 3.0 调用这个方法
        public void openFileChooser(ValueCallback<Uri> uploadMsg) {
            mUploadMessage = uploadMsg;
            choosePicture();
        }
    }

}
