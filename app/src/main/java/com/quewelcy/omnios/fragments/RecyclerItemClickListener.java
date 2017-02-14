package com.quewelcy.omnios.fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import static android.support.v7.widget.RecyclerView.OnItemTouchListener;
import static android.view.GestureDetector.SimpleOnGestureListener;

public class RecyclerItemClickListener implements OnItemTouchListener {

    private OnItemClickListener mClickListener;
    private GestureDetector mGestureDetector;
    private View childView;
    private int childViewPosition;

    RecyclerItemClickListener(Context context) {
        this(context, null);
    }

    public RecyclerItemClickListener(Context context, OnItemClickListener clickListener) {
        mClickListener = clickListener;
        mGestureDetector = new GestureDetector(context, new SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent event) {
                if (childView != null && mClickListener != null) {
                    mClickListener.onItemClick(childViewPosition);
                }
                return true;
            }

            @Override
            public void onLongPress(MotionEvent event) {
                if (childView != null && mClickListener != null) {
                    mClickListener.onItemLongClick(childViewPosition);
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        childView = view.findChildViewUnder(e.getX(), e.getY());
        childViewPosition = view.getChildAdapterPosition(childView);
        return childView != null && mGestureDetector.onTouchEvent(e);
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onItemLongClick(int position);
    }
}