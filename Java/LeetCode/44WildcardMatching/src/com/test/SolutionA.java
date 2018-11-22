package com.test;

import com.test.base.Solution;

/**
 * 函数
 * f(s, sIndex, p, pIndex); ?做特殊判断即可
 * 当p(pIndex) == *时，= f(s, sIndex+1, p, pIndex) || f(s, sIndex, p, pIndex+1)
 * 当p(pIndex) == *时，= s(sIndex) == p(pIndex) && f(s, sIndex, p, pIndex)
 * 
 * 时间复杂度
 * 测试：时间超时
 * 本机：未运行完成，反正超过 371s
 * 
 * @author YLine
 *
 * 2018年7月23日 下午4:25:13
 */
public class SolutionA implements Solution
{
    private static final char SINGLE = '?';
    
    private static final char MULTIFY = '*';
    
    @Override
    public boolean isMatch(String s, String p)
    {
        return dfs(s, 0, p, 0);
    }
    
    private boolean dfs(String s, int sIndex, String p, int pIndex)
    {
        if (pIndex == p.length())
        {
            if (sIndex == s.length())
            {
                return true;
            }
            return false;
        }
        
        if (MULTIFY == p.charAt(pIndex))
        {
            if (sIndex == s.length())
            {
                return dfs(s, sIndex, p, pIndex + 1);
            }
            else
            {
                return dfs(s, sIndex, p, pIndex + 1) || dfs(s, sIndex + 1, p, pIndex);
            }
        }
        else
        {
            if (sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || SINGLE == p.charAt(pIndex)))
            {
                return dfs(s, sIndex + 1, p, pIndex + 1);
            }
            else
            {
                return false;
            }
        }
    }
}
