package com.example.administrator.myapplication.model;

/**
 * Created by yy on 2016/12/26.
 */

public class Base<T> {
    private boolean result;
    private Object message;
    private T data;
    private String nonce_str;
    private double time_spend;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public double getTime_spend() {
        return time_spend;
    }

    public void setTime_spend(double time_spend) {
        this.time_spend = time_spend;
    }
}
