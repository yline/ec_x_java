package com.yline.log;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.yline.application.BaseApplication;
import com.yline.utils.FileUtil;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;

/**
 * 这个TAG,单独出去
 */
public final class CrashHandler implements UncaughtExceptionHandler
{
    private static final String TAG = "CrashHandler";
    
    private static final String CRASH_FILE_PATH =
        BaseApplication.getBaseConfig().getFileParentPath() + BaseApplication.getBaseConfig().getLogFilePath();
    
    private static final String CRASH_TXT_FILE = "CrashHandler.txt";
    
    private Application mApplication;
    
    // 用来存储设备信息和异常信息
    private Map<String, String> infoMap = new HashMap<String, String>();
    
    // 系统默认的UncaughtException处理类
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    
    private CrashHandler()
    {
    }
    
    public static CrashHandler getInstance()
    {
        return CrashHolder.instance;
    }
    
    private static class CrashHolder
    {
        private static CrashHandler instance = new CrashHandler();
    }
    
    public void init(Application application)
    {
        LogFileUtil.m("CrashHandler -> init start");
        
        mApplication = application;
        // 获取系统默认的UncaughtExceptionHandler
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        // 将该CrashHandler实例设置为默认异常处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
        
        LogFileUtil.m("CrashHandler -> init end");
    }
    
    @Override
    public void uncaughtException(Thread thread, Throwable ex)
    {
        LogFileUtil.v(TAG, "uncaughtException dealing");
        
        // 收集错误信息
        if (null != FileUtil.getPath())
        {
            handleException(ex);
        }
        
        if (ex instanceof UnsatisfiedLinkError)
        {
            BaseApplication.finishActivity();
        }
        
        mDefaultHandler.uncaughtException(thread, ex);
    }
    
    private boolean handleException(Throwable ex)
    {
        if (null == ex)
        {
            return false;
        }
        
        // 收集设备参数信息
        collectDeviceInfo(mApplication);
        
        // 保存日志文件
        saveCrashInfo2File(ex);
        
        // 日志打点      TrackerSendUtil.getInstance()  <SDK>
        
        // 发送一条退出时广播
        // mApplication.sendBroadcast(intent, receiverPermission);  <SDK>
        
        return true;
    }
    
    /**
     * 收集设备参数信息
     * @param context
     */
    private void collectDeviceInfo(Context context)
    {
        String crashTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA)
            .format(Long.valueOf(System.currentTimeMillis()));
        infoMap.put("CrashTime", crashTime);
        
        // 记录版本信息
        try
        {
            // 获得包管理器
            PackageManager pm = context.getPackageManager();
            
            // 得到该应用的信息，即主Activity
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
            if (null != packageInfo)
            {
                String versionName = null == packageInfo.versionName ? "null" : packageInfo.versionName;
                String versionCode = packageInfo.versionCode + "";
                infoMap.put("versionName", versionName);
                infoMap.put("versionCode", versionCode);
            }
        }
        catch (NameNotFoundException e)
        {
            LogFileUtil.e(TAG, "collectDeviceInfo -> NameNotFoundException error happened");
        }
        
        // 记录设备信息
        Field[] fields = Build.class.getDeclaredFields();// 反射机制
        for (Field field : fields)
        {
            try
            {
                field.setAccessible(true);
                infoMap.put(field.getName(), field.get("").toString());
                LogFileUtil.v(TAG, field.getName() + ":" + field.get(""));
            }
            catch (IllegalArgumentException e)
            {
                LogFileUtil.e(TAG, "getDeclaredFields -> IllegalArgumentException  error happened");
            }
            catch (IllegalAccessException e)
            {
                LogFileUtil.e(TAG, "getDeclaredFields -> IllegalAccessException  error happened");
            }
        }
    }
    
    /**
     * 保存信息到文件中
     * @param ex
     * @return
     */
    private void saveCrashInfo2File(Throwable ex)
    {
        // 定位哪个设备,哪个程序等信息
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : infoMap.entrySet())
        {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append("key = " + key + ",value = " + value + "\r\n");
        }
        
        // 写入异常信息       定位错误的信息
        Writer writer = new StringWriter();
        PrintWriter pw = new PrintWriter(writer);
        ex.printStackTrace(pw);
        Throwable cause = ex.getCause();
        // 循环着把所有的异常信息写入writer中
        while (cause != null)
        {
            cause.printStackTrace(pw);
            cause = cause.getCause();
        }
        
        // 记得关闭
        pw.close();
        String result = writer.toString();
        sb.append(result);
        
        // 保存文件
        writeLogToFile(sb.toString());
    }
    
    /**
     * 写日志入文件
     * @param content   日志内容
     */
    private synchronized static void writeLogToFile(String content)
    {
        String path = FileUtil.getPath();
        if (null == path)
        {
            LogFileUtil.e(TAG, "sdcard path is null");
            return;
        }
        
        File dirFile = FileUtil.createFileDir(path + CRASH_FILE_PATH);
        if (null == dirFile)
        {
            LogFileUtil.e(TAG, "sdcard dirFile create failed");
            return;
        }
        
        File file = FileUtil.createFile(dirFile, CRASH_TXT_FILE);
        if (null == file)
        {
            LogFileUtil.e(TAG, "sdcard file create failed");
            return;
        }
        
        if (!FileUtil.writeToFile(file, content))
        {
            LogFileUtil.e(TAG, "write failed");
            return;
        }
    }
}