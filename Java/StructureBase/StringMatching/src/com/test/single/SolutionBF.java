package com.test.single;

/**
 * BF 是 Brute Force 的缩写，中文叫作暴力匹配算法，也叫朴素匹配算法。
 * 
 * n : 主串长度
 * m : 模式串长度
 * 
 * 1，时间复杂度为O(n*m)
 * 
 * @author YLine
 *
 * 2019年3月26日 上午10:08:52
 */
public class SolutionBF implements SingleModelSolution
{
    
    @Override
    public int matching(String mainStr, String patternStr)
    {
        if (patternStr.length() > mainStr.length())
        {
            return ERROR;
        }
        
        // 暴力逐个匹配
        int restLength = mainStr.length() - patternStr.length() + 1;
        for (int i = 0; i < restLength; i++)
        {
            if (isEqual(mainStr, patternStr, i))
            {
                return i;
            }
        }
        
        return ERROR;
    }
    
    private boolean isEqual(String mainStr, String patternStr, int start)
    {
        for (int i = 0; i < patternStr.length(); i++)
        {
            if (patternStr.charAt(i) != mainStr.charAt(start + i))
            {
                return false;
            }
        }
        
        return true;
    }
}
