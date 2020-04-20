package com.example.vertical_tablayout_viewpager.verticaltablayout.verticaltabpager;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vertical_tablayout_viewpager.R;


/**
 * author:lgh on 2020-04-20 11:14
 */
public class VerticalPagerViewHolder extends RecyclerView.ViewHolder {

    MyRecyclerview mRecyclerView;

    public VerticalPagerViewHolder(@NonNull View itemView) {
        super(itemView);
        mRecyclerView = itemView.findViewById(R.id.pager2_rv);

    }
}
