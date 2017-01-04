package com.example.administrator.myapplication.p;

import com.example.administrator.myapplication.model.NewsList;

import java.util.List;

/**
 * Created by yy on 2016/12/22.
 */

public interface INewsView {

     void get_lv_data(List<NewsList> data);

     void showLoading();

     void hideLoading();
}
