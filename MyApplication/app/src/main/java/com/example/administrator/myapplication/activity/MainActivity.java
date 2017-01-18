package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.Rxjava.RxActivity;
import com.example.administrator.myapplication.activity.mio.MioActivity;
import com.example.administrator.myapplication.activity.okgo.OkgoActivity;
import com.example.administrator.myapplication.activity.simple.AdMobActivity;
import com.example.administrator.myapplication.activity.simple.BasicActivity;
import com.example.administrator.myapplication.activity.simple.DrawerActivity;
import com.example.administrator.myapplication.activity.simple.EmptyActivity;
import com.example.administrator.myapplication.activity.simple.FullscreenActivity;
import com.example.administrator.myapplication.activity.simple.ItemListActivity;
import com.example.administrator.myapplication.activity.simple.LoginActivity;
import com.example.administrator.myapplication.activity.simple.MapsActivity;
import com.example.administrator.myapplication.activity.simple.ScrollingActivity;
import com.example.administrator.myapplication.activity.simple.SettingsActivity;
import com.example.administrator.myapplication.activity.simple.TabActivity;
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
                        startActivity(new Intent(MainActivity.this, RxActivity.class));
//                        startActivity(new Intent(MainActivity.this, X5WebViewActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, MioActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, TabActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this, ScrollingActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this, BasicActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(MainActivity.this, DrawerActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(MainActivity.this, EmptyActivity.class));
                        break;
                    case 12:
                        startActivity(new Intent(MainActivity.this, AdMobActivity.class));
                        break;
                    case 13:
                        startActivity(new Intent(MainActivity.this, FullscreenActivity.class));
                        break;
                    case 14:
                        startActivity(new Intent(MainActivity.this, MapsActivity.class));
                        break;
                    case 15:
                        startActivity(new Intent(MainActivity.this, ItemListActivity.class));
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

        MainModel rxdol3 = new MainModel();
        rxdol3.setTitle("okRx");
        rxdol3.setDes("okrx用法");
        rxdol3.setType(1);
        mDatas.add(rxdol3);

//        MainModel dol3 = new MainModel();
//        dol3.setTitle("腾讯X5webview壳");
//        dol3.setDes("比原生的webview更强大");
//        dol3.setType(1);
//        mDatas.add(dol3);

        MainModel dol4 = new MainModel();
        dol4.setTitle("系统UI案例");
        dol4.setType(0);
        mDatas.add(dol4);

        MainModel dol5 = new MainModel();
        dol5.setTitle("蜜藕界面架构");
        dol5.setDes("Mio界面架构");
        dol5.setType(1);
        mDatas.add(dol5);

        MainModel dol6 = new MainModel();
        dol6.setTitle("TabActivity");
        dol6.setDes("tab样式");
        dol6.setType(1);
        mDatas.add(dol6);

        MainModel dol7 = new MainModel();
        dol7.setTitle("ScrollActivity");
        dol7.setDes("scroll样式");
        dol7.setType(1);
        mDatas.add(dol7);

        MainModel dol8 = new MainModel();
        dol8.setTitle("LoginActivity");
        dol8.setDes("Login样式");
        dol8.setType(1);
        mDatas.add(dol8);

        MainModel dol9 = new MainModel();
        dol9.setTitle("SettingsActivity");
        dol9.setDes("Settings样式");
        dol9.setType(1);
        mDatas.add(dol9);

        MainModel dol10 = new MainModel();
        dol10.setTitle("BasicActivity");
        dol10.setDes("Basic样式");
        dol10.setType(1);
        mDatas.add(dol10);

        MainModel dol11 = new MainModel();
        dol11.setTitle("DrawerActivity");
        dol11.setDes("Drawer样式");
        dol11.setType(1);
        mDatas.add(dol11);

        MainModel dol12 = new MainModel();
        dol12.setTitle("EmptyActivity");
        dol12.setDes("Empty样式");
        dol12.setType(1);
        mDatas.add(dol12);

        MainModel dol13 = new MainModel();
        dol13.setTitle("AdMobActivity");
        dol13.setDes("AdMob样式");
        dol13.setType(1);
        mDatas.add(dol13);

        MainModel dol14 = new MainModel();
        dol14.setTitle("FullscreenActivity");
        dol14.setDes("Fullscreen样式");
        dol14.setType(1);
        mDatas.add(dol14);

        MainModel dol15 = new MainModel();
        dol15.setTitle("MapsActivity");
        dol15.setDes("Maps样式");
        dol15.setType(1);
        mDatas.add(dol15);

        MainModel dol16 = new MainModel();
        dol16.setTitle("ItemListActivity");
        dol16.setDes("菜单加内容模式");
        dol16.setType(1);
        mDatas.add(dol16);

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
