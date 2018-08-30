package com.test;

import com.test.base.Solution;

/**
 * 方案：逐个遍历
 * 
 * 时间复杂度：
 * n*m
 * 
 * @author YLine
 *
 * 2018年8月30日 上午9:27:48
 */
public class SolutionA implements Solution
{
    @Override
    public int strStr(String haystack, String needle)
    {
        int stackLength = haystack.length();
        int needleLength = needle.length();
        if (needleLength == 0)
        {
            return 0;
        }
        
        int index = 0;
        
        int temp = 0;
        boolean isEqual = true;
        
        while (index + needleLength <= stackLength)
        {
            isEqual = (needle.charAt(temp) == haystack.charAt(temp + index));
            while (isEqual)
            {
                if (temp == needleLength - 1)
                {
                    return index;
                }
                
                temp++;
                isEqual = (needle.charAt(temp) == haystack.charAt(temp + index));
            }
            
            temp = 0;
            index++;
        }
        
        return -1;
    }
}
