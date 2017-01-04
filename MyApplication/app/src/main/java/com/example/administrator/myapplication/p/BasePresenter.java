package com.example.administrator.myapplication.p;


import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created on 2017/1/3.
 * Author：yy
 * Description:mvp架构:p的基类
 */


public abstract class BasePresenter<T>{
    protected Reference<T> viewRef;  //弱引用,防止内存泄漏
    public  void attachView(T view){
        viewRef=new WeakReference<T>(view);
    }
    public  void detachView(){
        if(viewRef!=null){
            viewRef.clear();
            viewRef=null;
        }
    }

}
