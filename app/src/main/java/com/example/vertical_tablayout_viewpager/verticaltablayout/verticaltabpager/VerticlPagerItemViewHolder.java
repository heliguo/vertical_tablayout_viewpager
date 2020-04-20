package com.example.vertical_tablayout_viewpager.verticaltablayout.verticaltabpager;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vertical_tablayout_viewpager.R;

/**
 * author:lgh on 2020-04-20 14:18
 */
public class VerticlPagerItemViewHolder extends RecyclerView.ViewHolder {

    TextView sjxm;
    TextView cph;
    TextView sfz;
    TextView sjh;
    TextView cydw;
    TextView hpmc;
    LinearLayout mLayout;


    public VerticlPagerItemViewHolder(@NonNull View itemView) {
        super(itemView);

        mLayout = itemView.findViewById(R.id.ll_list_recycler);
        sjxm = itemView.findViewById(R.id.tv_sjxm);
        cph = itemView.findViewById(R.id.tv_cph);
        sfz = itemView.findViewById(R.id.tv_sfz);
        sjh = itemView.findViewById(R.id.tv_sjh);
        cydw = itemView.findViewById(R.id.tv_cydw);
        hpmc = itemView.findViewById(R.id.tv_hpmc);

    }
}
