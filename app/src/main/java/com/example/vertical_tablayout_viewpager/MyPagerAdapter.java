package com.example.vertical_tablayout_viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author:lgh on 2020-04-17 10:49
 */
public class MyPagerAdapter extends RecyclerView.Adapter<MyPagerAdapter.MyHolder> {

    List<String> datas;

    public MyPagerAdapter() {
        datas = new ArrayList<>();
        Collections.addAll(datas, "1", "2", "3", "4");
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,
                parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.mTextView.setText(datas.get(position));

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        MyHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.item_title);
        }
    }

}
