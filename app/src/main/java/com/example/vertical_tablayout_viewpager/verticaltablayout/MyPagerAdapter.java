package com.example.vertical_tablayout_viewpager.verticaltablayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vertical_tablayout_viewpager.R;
import com.example.vertical_tablayout_viewpager.utils.DividerItemDecoration1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author:lgh on 2020-04-17 10:49
 */
public class MyPagerAdapter extends RecyclerView.Adapter<MyPagerAdapter.MyHolder> {

    List<String> datas;
    //    private final RecyclerView.RecycledViewPool mPool;

    public MyPagerAdapter() {
        //        mPool = new RecyclerView.RecycledViewPool();
        datas = new ArrayList<>();
        Collections.addAll(datas, "1", "2", "3", "4");
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vp_layout,
                parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.mMyRecyclerviewAdapter.setPage(position + 1);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {

        MyRecyclerview mRecyclerView;
        private final MyRecyclerviewAdapter mMyRecyclerviewAdapter;

        MyHolder(@NonNull View itemView) {
            super(itemView);
            //若ViewHolder不存在复用的情况，该写法与在onBindViewHolder创建没区别
            //在onBindViewHolder调用次数多（存在ViewHolder复用）的情况下使用效果明显
            mRecyclerView = itemView.findViewById(R.id.pager_rv);
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
