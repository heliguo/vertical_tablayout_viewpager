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

    private int mDy;

    public MyRecyclerview(@NonNull Context context) {
        this(context, null);
    }

    public MyRecyclerview(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyRecyclerview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent e) {
        Log.e("touch", "onTouchEvent: " );
        getParent().requestDisallowInterceptTouchEvent(true);
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!canScrollVertically(1) && mDy > 0) {//不可下滑且下滑
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                if (!canScrollVertically(-1) && mDy < 0) {//不可上滑且上滑
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_MOVE:

                break;
        }
        return super.onTouchEvent(e);
    }

    @Override
    public void onScrolled(int dx, int dy) {
        mDy = dy;
        Log.e("scroll", "onScrolled: " );
        super.onScrolled(dx, dy);
    }

}
