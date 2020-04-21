package com.example.vertical_tablayout_viewpager.verticaltablayout.verticaltabpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author:lgh on 2020-04-20 15:50
 */
public class MyRecyclerview extends RecyclerView {

    private int startY;

    public MyRecyclerview(@NonNull Context context) {
        this(context, null);
    }

    public MyRecyclerview(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyRecyclerview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 内部拦截
     * 1、dispatchTouchEvent
     * 2、OnInterruptTouchEvent
     * 3、OnTouchEvent
     *
     * @param ev 动作事件
     * @return true 拦截  false 不拦截
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startY = ((int) ev.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                int current = ((int) ev.getY());
                int offset = current - startY;

                if (!canScrollVertically(1) && offset < 0) {//不可下滑且下滑
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                if (!canScrollVertically(-1) && offset > 0) {//不可上滑且上滑
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


}
