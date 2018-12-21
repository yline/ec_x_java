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
    @Override
    public int strStr(String haystack, String needle)
    {
        if (needle.length() == 0)
        {
            return 0;
        }
        
        haystack.indexOf(needle);
        
        return kmpIndex(haystack, needle);
    }
    
    private int kmpIndex(String haystack, String needle)
    {
        int i = 0;
        int j = 0;
        int[] next = getNext(needle);
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
    
    public static int[] next(String needle)
    {
        int[] next = new int[needle.length()];
        
        next[0] = 0;
        next[1] = 0;
        
        int temp = 0;
        for (int i = 1; i < needle.length(); i++)
        {
            
        }
        
        return next;
    }
    
    public static int[] getNext(String needle)
    {
        int[] next = new int[needle.length()];
        
        next[0] = -1;
        int k = -1;
        int index = 0;
        while (index < needle.length() - 1)
        {
            if (k == -1)
            {
                index++;
                k = 0;
                next[index] = 0;
            }
            else if (needle.charAt(k) == needle.charAt(index))
            {
                index++;
                k++;
                next[index] = k;
            }
            else
            {
                // k = -1;
                k = next[k];
                // k = 0;
            }
            /*
            if (k == -1 || needle.charAt(k) == needle.charAt(index))
            {
                index++;
                k++;
                next[index] = k;
            }
            else
            {
                k = next[k];
            }*/
        }
        
        return next;
    }
}
