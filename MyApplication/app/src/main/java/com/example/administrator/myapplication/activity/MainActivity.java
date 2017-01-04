package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.okgo.OkgoActivity;
import com.example.administrator.myapplication.activity.webview.X5WebViewActivity;
import com.example.administrator.myapplication.model.MainModel;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private List<MainModel> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        get_data();
        MultiItemTypeAdapter adapter = new MultiItemTypeAdapter(this, mDatas); //万能适配rv: https://github.com/hongyangAndroid/baseAdapter
        adapter.addItemViewDelegate(new TitleItemDelagate());
        adapter.addItemViewDelegate(new ContextItemDelagate());
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                switch (position) {
                    case 1:
                        startActivity(new Intent(MainActivity.this, OkgoActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, X5WebViewActivity.class));
                        break;
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    public void get_data() {
        MainModel dol1 = new MainModel();
        dol1.setTitle("网络框架");
        dol1.setType(0);
        mDatas.add(dol1);

        MainModel dol2 = new MainModel();
        dol2.setTitle("okgo");
        dol2.setDes("1.基于okhttp,完美结合RxJava\n" +
                "2.比Retrofit更简单方便\n" +
                "3.支持文件上传，下载\n" +
                "4.强大的缓存功能\n" +
                "5.支持Json数据的自动解析转换");
        dol2.setType(1);
        mDatas.add(dol2);

        MainModel dol3 = new MainModel();
        dol3.setTitle("腾讯X5webview壳");
        dol3.setDes("比原生的webview更强大");
        dol3.setType(1);
        mDatas.add(dol3);

    }
}

class ContextItemDelagate implements ItemViewDelegate<MainModel> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_main_list;
    }

    @Override
    public boolean isForViewType(MainModel item, int position) {
        return item.getType() == 1 ? true : false;
    }

    @Override
    public void convert(ViewHolder holder, MainModel message, int position) {
        holder.setText(R.id.main_context_title, message.getTitle());
        holder.setText(R.id.main_context_des, message.getDes());
    }
}

class TitleItemDelagate implements ItemViewDelegate<MainModel> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_main_type;
    }

    @Override
    public boolean isForViewType(MainModel item, int position) {
        return item.getType() == 0 ? true : false;
    }

    @Override
    public void convert(ViewHolder holder, MainModel message, int position) {
        holder.setText(R.id.main_menu_divider, message.getTitle());
    }
}
