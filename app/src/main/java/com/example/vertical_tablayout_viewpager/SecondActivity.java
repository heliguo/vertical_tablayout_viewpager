package com.example.vertical_tablayout_viewpager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.vertical_tablayout_viewpager.verticaltablayout.TabLayoutMediator2;
import com.example.vertical_tablayout_viewpager.verticaltablayout.VerticalTabLayout;
import com.example.vertical_tablayout_viewpager.verticaltablayout.verticaltabpager.VerticalPagerAdapter;
import com.example.vertical_tablayout_viewpager.verticaltablayout.widget.TabView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * author:lgh on 2020-04-20 15:40
 */
public class SecondActivity extends AppCompatActivity {

    private VerticalTabLayout mTabLayout;
    private ViewPager2 mPager2;
    private VerticalPagerAdapter mAdapter;
    private JSONArray mArray;
    private String[] title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kcb_vertical_tab_pager);
        String data = getResources().getString(R.string.extra);
        try {
            JSONObject jo = new JSONObject(data);
            mArray = jo.getJSONArray("rows");
            title = new String[mArray.length()];
            for (int i = 0; i < mArray.length(); i++) {
                title[i] = mArray.getJSONObject(i).getString("CKTDH");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mTabLayout = findViewById(R.id.vertical_tablayout);
        mPager2 = findViewById(R.id.vertical_viewpager2);
        mAdapter = new VerticalPagerAdapter(mArray);
        mAdapter.setViewPager2(mPager2);
        mPager2.setAdapter(mAdapter);
        mPager2.setOffscreenPageLimit(1);
        TabLayoutMediator2 mediator2 = new TabLayoutMediator2(mTabLayout, mPager2, new TabLayoutMediator2.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabView tab, int position) {
                tab.getTitleView().setText(title[position]);
            }
        });
        mediator2.attach();
    }


}
