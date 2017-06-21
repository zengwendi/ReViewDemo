package com.goat.reviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BaseQuickAdapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private RecyclerView mRecycler1;
    private OneAdapter mAdapter;
    private OneAdapter twoAapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecycler1 = (RecyclerView) findViewById(R.id.recyclerView_other);
        mRecyclerView.setLayoutManager(new ScrollGridLayoutManager(this, 3));
        mRecycler1.setLayoutManager(new ScrollGridLayoutManager(this, 3));
        mAdapter = new OneAdapter(R.layout.item_one, getData(9));
        twoAapter = new OneAdapter(R.layout.item_one, getData(1));
        mRecyclerView.setAdapter(mAdapter);
        mRecycler1.setAdapter(twoAapter);
        twoAapter.setOnItemClickListener(this);
        findViewById(R.id.open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecycler1.setVisibility(mRecycler1.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });
    }

    private List<String> getData(int max) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            list.add("item" + i);
        }
        return list;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if (position == twoAapter.getData().size() - 1)
            twoAapter.add(twoAapter.getData().size() - 1, "item" + position);
    }
}
