package com.test;

public class Solution
{
    /**
     * Implement strStr().
     * 
     * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * 
     * @param haystack
     * @param needle
     * @return
     */
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
    
    /**
     * <pre>
     * 原题
     * Implement strStr().
     * Returns the index of the first occurrence of needle in haystack, or -1
     * if needle is not part of haystack.
     *
     * 题目大意
     * 实现实现strStr()函数，判断一个字符串在另一个字符串中出现的位置。如果不匹配就返回-1。
     *
     * 解题思路
     * 使用KMP算法进行实现
     * 
     *  PS:这一种,比我的还要优化,优化点在于:提前计算出了重复匹配的常量,这样一旦出现匹配失败,则跳跃一个较大的量,而不是1
     *  
     * </pre>
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle)
    {
        
        if (haystack == null || needle == null)
        {
            return -1;
        }
        
        if (needle.length() > haystack.length())
        {
            return -1;
        }
        
        if ("".equals(haystack))
        {
            if ("".equals(needle))
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }
        else
        {
            if ("".equals(needle))
            {
                return 0;
            }
        }
        
        return kmpIndex(haystack, needle);
    }
    
    private int kmpIndex(String haystack, String needle)
    {
        
        int i = 0;
        int j = 0;
        int[] next = next(needle);
        while (i < haystack.length() && j < needle.length())
        {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j))
            {
                ++i;
                ++j;
            }
            else
            {
                j = next[j];
            }
        }
        
        if (j == needle.length())
        {
            return i - j;
        }
        else
        {
            return -1;
        }
    }
    
    private int[] next(String needle)
    {
        int[] next = new int[needle.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        int k = needle.length() - 1;
        while (i < k)
        {
            if (j == -1 || needle.charAt(i) == needle.charAt(j))
            {
                ++i;
                ++j;
                if (needle.charAt(i) != needle.charAt(j))
                {
                    next[i] = j;
                }
                else
                {
                    next[i] = next[j];
                }
                
            }
            else
            {
                j = next[j];
            }
        }
        
        return next;
    }
}
