package com.yline.application;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yline.log.CrashHandler;
import com.yline.log.LogFileUtil;

/**
 * 后期所有的方法调用,可以采取xUtils一样,集成到x里面
 * 1, Log to File
 * 2, Log location
 * 3, 异常错误抛出记录
 * 4, Activity管理
 * 5, Application标配Handler、Application
 *
 * @author YLine 2016-5-25 -> 上午7:32:23
 * @version 
 */
public abstract class BaseApplication extends Application
{
    /** 先选用默认配置 */
    private static SDKConfig mBaseConfig = new SDKConfig();
    
    /** Activity管理 */
    private static List<Activity> mActivityList = new ArrayList<Activity>();
    
    /** Fragment记录 */
    private static List<String> mFragmentList = new ArrayList<String>();
    
    /** View记录 */
    private static List<String> mViewList = new ArrayList<String>();
    
    /** Service记录 */
    private static List<String> mServiceList = new ArrayList<String>();
    
    private static Application mApplication;
    
    // handler相关
    private static Handler handler;
    
    /** Toast 工具 */
    private Toast mToast;
    
    private TextView mTvToast;
    
    /**
     * @return  当前application,因为onCreate为应用入口,因此不用担心为null
     */
    public static Application getApplication()
    {
        return mApplication;
    }
    
    private void setApplication(Application application)
    {
        BaseApplication.mApplication = application;
    }
    
    public static void addAcitivity(Activity activity)
    {
        LogFileUtil.m("addAcitivity:" + activity.getClass().getSimpleName());
        mActivityList.add(activity);
    }
    
    public static void removeActivity(Activity activity)
    {
        LogFileUtil.m("removeActivity:" + activity.getClass().getSimpleName());
        mActivityList.remove(activity);
    }
    
    public static void finishActivity()
    {
        for (Activity activity : mActivityList)
        {
            LogFileUtil.m("finishActivity:" + activity.getClass().getSimpleName());
            activity.finish();
        }
    }
    
    public static void addFragmentForRecord(Fragment fragment)
    {
        LogFileUtil.m("addFragmentForRecord:" + fragment.getClass().getSimpleName());
        mFragmentList.add(fragment.getClass().getSimpleName());
    }
    
    public static void removeFragmentForRecord(Fragment fragment)
    {
        LogFileUtil.m("removeFragmentForRecord:" + fragment.getClass().getSimpleName());
        mFragmentList.remove(fragment.getClass().getSimpleName());
    }
    
    public static void addViewForRecord(View view)
    {
        LogFileUtil.m("addViewForRecord:" + view.getClass().getSimpleName());
        mViewList.add(view.getClass().getSimpleName());
    }
    
    public static void removeViewForRecord(View view)
    {
        LogFileUtil.m("removeViewForRecord:" + view.getClass().getSimpleName());
        mViewList.remove(view.getClass().getSimpleName());
    }
    
    public static void addServiceForRecord(Service service)
    {
        LogFileUtil.m("addServiceForRecord:" + service.getClass().getSimpleName());
        mServiceList.add(service.getClass().getSimpleName());
    }
    
    public static void removeServiceForRecord(Service service)
    {
        LogFileUtil.m("removeServiceForRecord:" + service.getClass().getSimpleName());
        mServiceList.remove(service.getClass().getSimpleName());
    }
    
    /**
     * @return 当前Application的配置信息
     */
    public static SDKConfig getBaseConfig()
    {
        return mBaseConfig;
    }
    
    /**
     * 配置当前Application的配置信息
     * 返回null,则按默认配置
     * @param mBaseConfig 配置对象
     */
    private void setBaseConfig(SDKConfig mBaseConfig)
    {
        if (null != mBaseConfig)
        {
            BaseApplication.mBaseConfig = mBaseConfig;
        }
    }
    
    /**
     * 更改资源的时候,才需要做一步操作,引用不需要
     * 原子操作
     * @return
     */
    public static Handler getHandler()
    {
        return handler;
    }
    
    @SuppressLint("HandlerLeak")
    @Override
    public void onCreate()
    {
        super.onCreate();
        setApplication(this); // 初始化全局变量
        
        // 配置,定制基础信息
        setBaseConfig(initConfig());
        
        // 设立一个程序入口的log
        LogFileUtil.m(mBaseConfig.toString());
        for (int i = 0; i < 3; i++)
        {
            LogFileUtil.m("应用启动 *** application start id = " + Thread.currentThread().getId());
        }
        
        // 异常崩溃日志
        CrashHandler.getInstance().init(this);
        
        SDKService.initAppService(this); // 伴生服务
        
        handler = new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                super.handleMessage(msg);
                switch (msg.what)
                {
                    case SDKConstant.HANDLER_TOAST:
                        showToast(BaseApplication.this, (String)msg.obj);
                        break;
                    default:
                        break;
                }
            }
        };
    }
    
    /**
     * 打印toast
     * @param context
     * @param msg 内容
     */
    private void showToast(Context context, String msg)
    {
        if (null == mToast)
        {
            mToast = new Toast(context);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        
        if (null == mTvToast)
        {
            mTvToast = new TextView(context);
            mTvToast.setPadding(10, 6, 10, 6);
            mTvToast.setBackgroundColor(0xff333333);
            mTvToast.setTextColor(0xffffffff);
        }
        
        mTvToast.setText(msg);
        mToast.setView(mTvToast);
        mToast.show();
    }
    
    /**
     * 吐司
     * @param content
     */
    public static void toast(String content)
    {
        handler.obtainMessage(SDKConstant.HANDLER_TOAST, content).sendToTarget();
    }
    
    /**
     * 进行一些基础配置,要求上级必须配置的信息
     * @return
     */
    protected SDKConfig initConfig()
    {
        // do nothing
        return new SDKConfig();
    }
    
}
