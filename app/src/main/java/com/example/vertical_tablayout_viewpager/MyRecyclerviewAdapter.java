package com.example.vertical_tablayout_viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author lgh on 2020/5/19 16:56
 * @description
 */
public class MyRecyclerviewAdapter extends RecyclerView.Adapter<MyRecyclerviewAdapter.PagerViewHolder> {


    private int page;

    @NonNull
    @Override
    public PagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_layout,
                parent, false);
        return new PagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PagerViewHolder holder, int position) {

        holder.mTextView.setText(String.format("第%d页,第%d项", page, position));

    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    class PagerViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public PagerViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.rv_item_tv);
        }
    }

}
