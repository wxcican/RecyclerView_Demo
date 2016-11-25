package com.fuicuiedu.idedemo.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        initdata();
        //设置布局管理器
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        //设置adapter
        adapter = new MyAdapter(mDatas);
        recyclerView.setAdapter(adapter);
        //设置item增加。删除动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        //设置点击监听
        adapter.setOnItemClickedListener(new MyAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Toast.makeText(MainActivity.this, "点击了" + postion, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int postion) {
                Toast.makeText(MainActivity.this, "长按了" + postion, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initdata(){
        mDatas = new ArrayList<>();
        for (int i = 0;i<100;i++){
            mDatas.add(i + "");
        }
    }

}
