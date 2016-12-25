package com.test;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * @author YLine
 *
 * 2016年12月25日 下午2:35:03
 */
public class Solution
{
    public boolean isMatch(String s, String p)
    {
        return false;
    }
    
    private boolean isEqual(String a, String b)
    {
        
        boolean result = false;
        
        if (null == a && null == b)
        {
            return true;
        }
        
        if ("".equals(a) && "".equals(b))
        {
            return true;
        }
        
        if (null != a && null != b && a.length() == b.length())
        {
            for (int i = 0; i < a.length(); i++)
            {
                
            }
        }
        
        if (null == a || null == b)
        {
            return false;
        }
        
        if (a.length() != b.length())
        {
            return false;
        }
        
        return result;
    }
}
