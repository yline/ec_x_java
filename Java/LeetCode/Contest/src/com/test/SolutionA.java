package com.test;

/**
 * 考的是 BM/KMP算法
 * 
 * 临时写不出来，于是乎，暴力遍历怎么样
 * 
 * @author YLine
 *
 * 2019年6月16日 上午11:25:54
 */
public class SolutionA
{
    public String shortestCommonSupersequence(String str1, String str2)
    {
        String main, pattern;
        if (str1.length() >= str2.length())
        {
            main = str1;
            pattern = str2;
        }
        else
        {
            main = str2;
            pattern = str1;
        }
        
        // 中间包含关系
        if (str1.indexOf(str2) != -1)
        {
            return str1;
        }
        
        String result = pattern + main;
        int leftSize = -1;
        
        // 左匹配
        for (int i = pattern.length() - 2; i >= 0; i--)
        {
            if (matchLeft(main, pattern, i, pattern.length() - 1))
            {
                leftSize = i + 1; // 相同的个数
                result = pattern.substring(0, pattern.length() - i - 1) + main;
                break;
            }
        }
        
        // 右匹配
        for (int i = pattern.length() - 2; i >= 0; i--)
        {
            if (i + 1 <= leftSize) // 已经比上次的少了，直接结束
            {
                return result;
            }
            else
            {
                if (matchRight(main, pattern, main.length() - i - 1))
                {
                    result = main + pattern.substring(i + 1);
                    break;
                }
            }
        }
        
        return result;
    }
    
    private boolean matchLeft(String main, String pattern, int mainEnd, int patternEnd)
    {
        for (int i = 0; i <= mainEnd; i++)
        {
            if (main.charAt(mainEnd - i) != pattern.charAt(patternEnd - i))
            {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean matchRight(String main, String pattern, int mainStart)
    {
        for (int i = mainStart; i < main.length(); i++)
        {
            if (main.charAt(i) != pattern.charAt(i - mainStart))
            {
                return false;
            }
        }
        return true;
    }
}
