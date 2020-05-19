package com.example.vertical_tablayout_viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vertical_tablayout_viewpager.utils.DividerItemDecoration1;
import com.example.vertical_tablayout_viewpager.verticaltablayout.verticaltabpager.MyRecyclerview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author:lgh on 2020-04-17 10:49
 */
public class MyPagerAdapter extends RecyclerView.Adapter<MyPagerAdapter.MyHolder> {

    List<String> datas;
    private Context mContext;

    public MyPagerAdapter() {
        datas = new ArrayList<>();
        Collections.addAll(datas, "1", "2", "3", "4");
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_vp_layout,
                parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        holder.mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        holder.mRecyclerView.addItemDecoration(new DividerItemDecoration1(mContext,
                DividerItemDecoration1.VERTICAL_LIST));//加分割线
        MyRecyclerviewAdapter myRecyclerviewAdapter = new MyRecyclerviewAdapter();
        myRecyclerviewAdapter.setPage(position + 1);
        holder.mRecyclerView.setAdapter(myRecyclerviewAdapter);


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {

        MyRecyclerview mRecyclerView;

        MyHolder(@NonNull View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.pager_rv);
        }
    }

}
