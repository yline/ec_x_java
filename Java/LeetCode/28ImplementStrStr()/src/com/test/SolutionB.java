package com.test;

import com.test.base.Solution;

/**
 * 使用KMP算法进行实现
 * 
 * 优化点在于:提前计算出了重复匹配的常量,这样一旦出现匹配失败,则跳跃一个较大的量,而不是1
 * 
 * 经过测试：优化效果并不是很明显（提交的测试）
 * 
 * @author YLine
 *
 * 2018年8月30日 上午9:35:26
 */
public class SolutionB implements Solution
{
    public int strStr(String haystack, String needle)
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
        
        int length = needle.length() - 1;
        while (i < length)
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
