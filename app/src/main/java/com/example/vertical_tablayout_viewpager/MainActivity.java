package com.example.vertical_tablayout_viewpager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.vertical_tablayout_viewpager.verticaltablayout.TabLayoutMediator2;
import com.example.vertical_tablayout_viewpager.verticaltablayout.VerticalTabLayout;
import com.example.vertical_tablayout_viewpager.verticaltablayout.widget.ITabView;
import com.example.vertical_tablayout_viewpager.verticaltablayout.widget.TabView;

public class MainActivity extends AppCompatActivity {

    ViewPager2         mViewPager2;
    VerticalTabLayout  mVerticalTabLayout;
    MyPagerAdapter     mAdapter;
    TabLayoutMediator2 mMediator2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVerticalTabLayout = findViewById(R.id.vertical_tablayout);
        mViewPager2 = findViewById(R.id.vertical_viewpager2);
        mAdapter = new MyPagerAdapter();
        mViewPager2.setAdapter(mAdapter);
        mViewPager2.setOffscreenPageLimit(1);
        mMediator2 = new TabLayoutMediator2(mVerticalTabLayout, mViewPager2,
                new TabLayoutMediator2.TabConfigurationStrategy() {

                    @Override
                    public void onConfigureTab(@NonNull TabView tab, int position) {
                        ITabView.TabTitle.Builder builder = new ITabView.TabTitle.Builder();
                        builder.setContent(String.format("第%d页", (position + 1)));
                        tab.setTitle(builder.build());
                    }
                });

        mMediator2.attach();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMediator2.detach();
    }
}
