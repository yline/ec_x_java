package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * @author YLine
 *
 * 2016年12月25日 下午2:32:21
 */
public class Solution
{
    public int reverse(int x)
    {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
        {
            return 0;
        }
        
        // 防止溢出
        long result = 0;
        
        int signX = x > 0 ? 1 : -1;
        int absX = x > 0 ? x : -x;
        
        List<Integer> numList = new ArrayList<>();
        
        while (absX != 0)
        {
            numList.add(absX % 10);
            absX = absX / 10;
        }
        
        System.out.println("list = " + numList.toString());
        
        for (int i = 0; i < numList.size(); i++)
        {
            result += numList.get(i) * Math.pow(10, numList.size() - 1 - i);
        }
        
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
        {
            return 0;
        }
        
        return (int)(signX * result);
    }
    
    /** 错误的 */
    public int reverse2(int x)
    {
        int signX = x > 0 ? 1 : -1;
        int absX = x > 0 ? x : -x;
        
        StringBuffer stringBuffer = new StringBuffer(absX + "");
        
        String resultStr = stringBuffer.reverse().toString();
        
        int result = signX * Integer.parseInt(resultStr);
        
        return result;
    }
}
