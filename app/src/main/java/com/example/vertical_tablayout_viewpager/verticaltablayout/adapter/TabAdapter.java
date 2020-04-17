package com.example.vertical_tablayout_viewpager.verticaltablayout.adapter;


import com.example.vertical_tablayout_viewpager.verticaltablayout.widget.TabView;

/**
 * @author chqiu
 *         Email:qstumn@163.com
 */
public interface TabAdapter {

    int getCount();

    TabView.TabBadge getBadge(int position);

    TabView.TabIcon getIcon(int position);

    TabView.TabTitle getTitle(int position);

    int getBackground(int position);
}
