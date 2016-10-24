package com.yline.base;

import com.yline.application.BaseApplication;
import com.yline.log.LogFileUtil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class BaseLinearLayout extends LinearLayout
{
    public BaseLinearLayout(Context context)
    {
        this(context, null);
    }
    
    public BaseLinearLayout(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }
    
    @SuppressLint("NewApi")
    public BaseLinearLayout(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        BaseApplication.addViewForRecord(this);
    }
    
    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();
        LogFileUtil.m("finishInflate:" + getClass().getSimpleName());
    }
    
    @Override
    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        BaseApplication.removeViewForRecord(this);
    }
}
