package com.example.administrator.myapplication.activity.mio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OneFragment extends DrawerFragment {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private CommonAdapter<String> adapter;
    private List<String> data = new ArrayList<String>();
    private LoadMoreWrapper loadMoreWrapper;
    private TextView mio;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one, container, false);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipeRefresh);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                // TODO Auto-generated method stub
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        data.clear();
                        data.add("添加新的item:" + new Random().nextInt());
                        for (int i = 1; i < 10; i++) {
                            data.add("测试：" + i);
                        }
                        loadMoreWrapper.notifyDataSetChanged();
                        //停止刷新动画
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });
        for (int i = 1; i < 10; i++) {
            data.add("测试：" + i);
        }
        adapter = new CommonAdapter<String>(getActivity(), R.layout.lv_item, data) {
            @Override
            protected void convert(ViewHolder holder, String text, int position) {
                holder.setText(R.id.lv_text, text);
            }
        };
        //添加footer
        loadMoreWrapper = new LoadMoreWrapper(adapter);
        loadMoreWrapper.setLoadMoreView(R.layout.footer_view);
        loadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            data.add("load more:" + i);
                        }
                        loadMoreWrapper.notifyDataSetChanged();

                    }
                }, 2000);
            }
        });
        recyclerView.setAdapter(loadMoreWrapper);
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                startActivity(new Intent(getActivity(), DetailActivity.class));
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        mio = (TextView) v.findViewById(R.id.mio);
        mio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDrawerListener.openDrawer();
            }
        });
        return v;
    }
}
