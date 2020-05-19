package com.example.vertical_tablayout_viewpager.verticaltablayout.verticaltabpager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author:lgh on 2020-04-20 15:50
 */
public class MyRecyclerview extends RecyclerView {

    private int startY;
    private int mVelocityY;

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
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mVelocityY = 0;
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int offset = y - startY;
                if (!canScrollVertically(1) && offset < 0 &&
                        Math.abs(mVelocityY) < 8000) {//不可下滑且下滑
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                if (!canScrollVertically(-1) && offset > 0 &&
                        Math.abs(mVelocityY) < 8000) {//不可上滑且上滑,
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
        }
        startY = y;
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 滑动速度大于8000
     *
     * @param velocityX
     * @param velocityY
     * @return
     */
    @Override
    public boolean fling(int velocityX, int velocityY) {
        this.mVelocityY = velocityY;
        return super.fling(velocityX, velocityY);
    }


}
