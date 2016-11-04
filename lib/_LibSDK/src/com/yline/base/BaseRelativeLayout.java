package com.yline.base;

import com.yline.application.BaseApplication;
import com.yline.log.LogFileUtil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class BaseRelativeLayout extends RelativeLayout
{
    
    public BaseRelativeLayout(Context context)
    {
        this(context, null);
    }
    
    public BaseRelativeLayout(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }
    
    public BaseRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr)
    {
        this(context, attrs, defStyleAttr, 0);
    }
    
    @SuppressLint("NewApi")
    public BaseRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
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
