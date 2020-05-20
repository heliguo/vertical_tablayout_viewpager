package com.example.vertical_tablayout_viewpager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vertical_tablayout_viewpager.utils.DividerItemDecoration1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author:lgh on 2020-04-17 10:49
 */
public class MyPagerAdapter2 extends RecyclerView.Adapter<MyPagerAdapter2.MyHolder2> {

    List<String> datas;
//    private final RecyclerView.RecycledViewPool mPool;

    public MyPagerAdapter2() {
//        mPool = new RecyclerView.RecycledViewPool();
        datas = new ArrayList<>();
        Collections.addAll(datas, "1", "2", "3", "4");
    }

    @NonNull
    @Override
    public MyHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vp_layout2,
                parent, false);
        Log.e("TAG", "onCreateViewHolder: " + System.currentTimeMillis());
        return new MyHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder2 holder, int position) {
        Log.e("TAG", "onBindViewHolder: " + System.currentTimeMillis());
        holder.mMyRecyclerviewAdapter.setPage(position + 1);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyHolder2 extends RecyclerView.ViewHolder {

        RecyclerView mRecyclerView;
        private final MyRecyclerviewAdapter mMyRecyclerviewAdapter;

        MyHolder2(@NonNull View itemView) {
            super(itemView);
            //若ViewHolder不存在复用的情况，该写法与在onBindViewHolder创建没区别
            //在onBindViewHolder调用次数多（存在ViewHolder复用）的情况下使用效果明显
            mRecyclerView = itemView.findViewById(R.id.pager_rv2);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
//            linearLayoutManager.setRecycleChildrenOnDetach(true);
            mRecyclerView.setLayoutManager(linearLayoutManager);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView.addItemDecoration(new DividerItemDecoration1(itemView.getContext(),
                    DividerItemDecoration1.VERTICAL_LIST));//加分割线
            mMyRecyclerviewAdapter = new MyRecyclerviewAdapter();
            mRecyclerView.setAdapter(mMyRecyclerviewAdapter);
//            mRecyclerView.setRecycledViewPool(mPool);
        }
    }

}
