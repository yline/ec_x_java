package com.test;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 写一个函数找出一个字串所数组中的最长的公共前缀。
 * @author YLine
 *
 * 2017年1月12日 下午8:22:24
 */
public class Solution
{
    public String longestCommonPrefix(String[] strs)
    {
        int length = strs.length;
        
        if (length == 0)
        {
            return "";
        }
        
        while (length > 1)
        {
            for (int i = 0; i < (length + 1) / 2; i++)
            {
                if ((2 * i + 1) >= length)
                {
                    strs[i] = strs[2 * i];
                }
                else
                {
                    strs[i] = getCommonPrefix(strs[2 * i], strs[2 * i + 1]);
                }
            }
            
            length = (length + 1) / 2;
        }
        
        return strs[0];
    }
    
    private String getCommonPrefix(String s, String p)
    {
        StringBuffer result = new StringBuffer();
        if (null != s && null != p)
        {
            for (int i = 0; i < s.length(); i++)
            {
                if (i < p.length() && s.charAt(i) == p.charAt(i))
                {
                    result.append(s.charAt(i));
                }
                else
                {
                    break;
                }
            }
        }
        return result.toString();
    }
}
