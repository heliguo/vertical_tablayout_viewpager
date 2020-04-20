package com.example.vertical_tablayout_viewpager.verticaltablayout.verticaltabpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.vertical_tablayout_viewpager.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * author:lgh on 2020-04-20 11:14
 */
public class VerticalPagerAdapter extends RecyclerView.Adapter<VerticalPagerViewHolder> {

    private JSONArray datas;
    private Context mContext;
    private ViewPager2 mViewPager2;

    public VerticalPagerAdapter(JSONArray datas) {
        this.datas = datas;
    }

    public void setViewPager2(ViewPager2 viewPager2) {
        mViewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public VerticalPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.kcb_vertical_tab_pager_rv, parent, false);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
        return new VerticalPagerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull VerticalPagerViewHolder holder, final int position) {
        List<VerticalBean> data = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        holder.mRecyclerView.setLayoutManager(manager);
        holder.mRecyclerView.setTag(position);
        holder.mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        holder.mRecyclerView.addItemDecoration(new DividerItemDecoration1(mContext, DividerItemDecoration1.VERTICAL_LIST));//加分割线
        try {
            JSONObject jo = datas.getJSONObject(position);
            String thdw = jo.getString("THDW");
            String hpmc = jo.getString("HPMC");
            JSONArray kxhcl = jo.getJSONArray("KXHCL");
            for (int i = 0; i < kxhcl.length(); i++) {
                JSONObject jsonObject = kxhcl.getJSONObject(i);
                String sjmc = jsonObject.getString("KXHCL_SJMC");
                String phone = jsonObject.getString("PHONE");
                String cphm = jsonObject.getString("KXHCL_CPHM");
                String sjsfz = jsonObject.getString("KXHCL_SJSFZ");
                String clxx = jsonObject.getString("CLXX");
                if (phone == null || phone.equals("") || phone.equals("null")) {
                    phone = "";
                }
                VerticalBean bean = new VerticalBean(sjmc, cphm, sjsfz, phone, thdw, hpmc, clxx, position, i);
                data.add(bean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        holder.mRecyclerView.setAdapter(new VerticalPagerItemAdapter(data));

    }


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.length();
    }
}
