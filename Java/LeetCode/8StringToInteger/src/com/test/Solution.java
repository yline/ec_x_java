package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * @author YLine
 *
 * 2016年12月25日 下午2:34:00
 */
public class Solution
{
    public int myAtoi(String str)
    {
        long result = 0;
        
        if (null == str || "".equals(str))
        {
            return 0;
        }
        
        int sign = 0;
        List<Integer> numList = new ArrayList<>();
        
        char symbol;
        
        for (int i = 0; i < str.length(); i++)
        {
            symbol = str.charAt(i);
            
            if (numList.size() == 0 && ' ' == symbol && (0 == sign))
            {
                continue;
            }
            
            if (numList.size() == 0 && (0 == sign))
            {
                if (symbol == '-')
                {
                    sign = -1;
                    continue;
                }
                
                if (symbol == '+')
                {
                    sign = 1;
                    continue;
                }
            }
            
            if (symbol >= '0' && symbol <= '9')
            {
                numList.add(symbol - '0');
            }
            else
            {
                break;
            }
        }
        
        // System.out.println("sign = " + sign + ",numList = " + numList.toString());
        
        for (int i = 0; i < numList.size(); i++)
        {
            result += numList.get(i) * Math.pow(10, numList.size() - 1 - i);
            if (sign == -1)
            {
                if (-1 * result < Integer.MIN_VALUE)
                {
                    return Integer.MIN_VALUE;
                }
            }
            else
            {
                if (result > Integer.MAX_VALUE)
                {
                    return Integer.MAX_VALUE;
                }
            }
        }
        
        if (sign == 0)
        {
            return (int)result;
        }
        
        return (int)(sign * result);
    }
}
