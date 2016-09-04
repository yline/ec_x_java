package com.yline.base;

import com.yline.application.BaseApplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * simple introduction
 *
 * @author YLine 2016-5-25 -> 上午7:32:43
 * @version 
 */
public class BaseFragment extends Fragment
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        BaseApplication.addFragmentForRecord(this);
    }
    
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        BaseApplication.removeFragmentForRecord(this);
    }
}
