package com.example.vertical_tablayout_viewpager.verticaltablayout.verticaltabpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vertical_tablayout_viewpager.R;

import java.util.List;

/**
 * author:lgh on 2020-04-20 14:21
 */
public class VerticalPagerItemAdapter extends RecyclerView.Adapter<VerticlPagerItemViewHolder> {

    private List<VerticalBean> datas;

    public VerticalPagerItemAdapter(List<VerticalBean> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public VerticlPagerItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.kcb_vertical_tab_pager_item, parent, false);
        return new VerticlPagerItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticlPagerItemViewHolder holder, final int position) {
        holder.sjxm.setText(datas.get(position).getSjmc());
        holder.cph.setText(datas.get(position).getCph());
        holder.sfz.setText(datas.get(position).getSfz());
        holder.sjh.setText(datas.get(position).getSjh());
        holder.cydw.setText(datas.get(position).getCydw());
        holder.hpmc.setText(datas.get(position).getHpmc());
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mVerticalItemClick != null) {
                    mVerticalItemClick.onItemClick(v, position, datas.get(position).getIndexTd(),
                            datas.get(position).getIndexCph(), datas.get(position).getClxx());
                }
            }
        });
    }

    private OnVerticalItemClick mVerticalItemClick;

    public void setDatas(List<VerticalBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void setVerticalItemClick(OnVerticalItemClick verticalItemClick) {
        mVerticalItemClick = verticalItemClick;
    }

    public interface OnVerticalItemClick {

        void onItemClick(View view, int position, int indexTd, int indexCph, String clxx);

    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }
}
