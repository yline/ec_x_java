package com.test;

/**
 * 假设有唯一解(冒泡排序法)
 * @author YLine
 *
 * 2016年12月15日 下午6:48:27
 */
public class Solution
{
    public int lengthOfLongestSubstring(String s)
    {
        int max = 0;
        
        for (int i = 0; i < s.length(); i++)
        {
            do
            {
                
            } while (false);
            
            String temp;
            for (int j = i + 1; j < s.length(); j++)
            {
                temp = s.substring(i, j);
                if (!temp.contains(s.charAt(j) + ""))
                {
                    break;
                }
            }
        }
        return max;
    }
}
