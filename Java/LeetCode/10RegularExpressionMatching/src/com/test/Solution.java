package com.test;

import java.util.Arrays;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'
 * 输入一个string和pattern，实现支持'.'和'*'的正则匹配
 * 
 * '.' Matches any single character.  '.'匹配任意一个，单个字符
 * '*' Matches zero or more of the preceding element. '*'匹配0到n个z,前一个字符
 * 
 * The matching should cover the entire input string (not partial).
 * 匹配，必须匹配整个字符串
 * 
 * Note:
 *  s could be empty and contains only lowercase letters a-z.
 *  p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * 
 * Example 1:
 *  Input:  s = "aa"  p = "a"
 *  Output: false
 *  Explanation: "a" does not match the entire string "aa".
 * 
 * Example 2:
 *  Input:  s = "aa"  p = "a*"
 *  Output: true
 *  Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * 
 * Example 3:
 *  Input:  s = "ab"  p = ".*"
 *  Output: true
 *  Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * Example 4:
 *  Input:  s = "aab"  p = "c*a*b"
 *  Output: true
 *  Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * 
 * Example 5:
 *  Input:  s = "mississippi"  p = "mis*is*p*."
 *  Output: false
 * 
 * @author YLine
 *
 * 2016年12月25日 下午2:35:03
 */
public class Solution
{
    public boolean isMatch3(String s, String p)
    {
        if (null == s && null == p)
        {
            return true;
        }
        
        if (null == s || null == p)
        {
            return false;
        }
        
        String[] pList = p.split(p);
        
        return false;
    }
    
    public boolean isMatch(String s, String p)
    {
        boolean[] match = new boolean[s.length() + 1];
        Arrays.fill(match, false);
        match[s.length()] = true;
        
        // 从末尾开始遍历
        for (int i = p.length() - 1; i >= 0; i--)
        {
            if (p.charAt(i) == '*')
            {
                for (int j = s.length() - 1; j >= 0; j--)
                {
                    match[j] = match[j] || match[j + 1] && (p.charAt(i - 1) == '.' || s.charAt(j) == p.charAt(i - 1));
                }
                i--;
            }
            else
            {
                for (int j = 0; j < s.length(); j++)
                {
                    match[j] = match[j + 1] && (p.charAt(i) == '.' || p.charAt(i) == s.charAt(j));
                }
                
                match[s.length()] = false;
            }
        }
        return match[0];
    }
    
    // 下面的代码用时比较长
    public boolean isMatch2(String s, String p)
    {
        // 输入都为null
        if (s == null && p == null)
        {
            return true;
        }
        // 有一个为null
        else if (s == null || p == null)
        {
            return false;
        }
        
        return isMatch(s, 0, p, 0);
    }
    
    /**
     * 正则表达式匹配
     *
     * @param s    匹配串
     * @param sIdx 当前匹配的位置
     * @param p    模式串
     * @param pIdx 模式串的匹配位置
     * @return 匹配结果
     */
    public boolean isMatch(String s, int sIdx, String p, int pIdx)
    {
        // 同时到各自的末尾
        if (s.length() == sIdx && p.length() == pIdx)
        {
            return true;
        }
        // 当匹配串没有到达末尾，模式串已经到了末尾
        else if (s.length() != sIdx && p.length() == pIdx)
        {
            return false;
        }
        // 其它情况
        else
        {
            // 如果当前匹配的下一个字符是*号
            if (pIdx < p.length() - 1 && p.charAt(pIdx + 1) == '*')
            {
                // 匹配串未结束并且当前字符匹配（字符相等或者是.号）
                if (sIdx < s.length() && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.'))
                {
                    return isMatch(s, sIdx + 1, p, pIdx + 2) // 匹配串向前移动一个字符（只匹配一次）
                        || isMatch(s, sIdx + 1, p, pIdx) //  匹配串向前移动一个字符（下一次匹配同样的（模式串不动））
                        || isMatch(s, sIdx, p, pIdx + 2); // 忽略匹配的模式串
                }
                else
                {
                    // 忽略*
                    return isMatch(s, sIdx, p, pIdx + 2);
                }
            }
            
            // 匹配一个字符
            if (sIdx < s.length() && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.'))
            {
                return isMatch(s, sIdx + 1, p, pIdx + 1);
            }
        }
        
        return false;
    }
    
}
