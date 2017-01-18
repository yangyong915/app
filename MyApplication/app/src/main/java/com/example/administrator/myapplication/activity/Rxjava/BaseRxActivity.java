package com.example.administrator.myapplication.activity.Rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.myapplication.R;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * 统一管理订阅周期
 */
public class BaseRxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_rx);
    }
    private CompositeSubscription compositeSubscription;

    public void addSubscribe(Subscription subscription) {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(subscription);
    }

    public void unSubscribe() {
        if (compositeSubscription != null) compositeSubscription.unsubscribe();
    }
}
