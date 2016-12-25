package com.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring
 * 
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
            for (int j = i; j < s.length(); j++)
            {
                max = Math.max(max, j + 1 - i);
                
                if (j == (s.length() - 1))
                {
                    return max; // 退出 两个for循环
                }
                
                if (s.substring(i, j + 1).contains(s.charAt(j + 1) + ""))
                {
                    break; // 退出当前for循环
                }
            }
        }
        return max;
    }
    
    /**
     * 官方给定的answer, 比较人性化的一个方案,而且效率高
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s)
    {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n)
        {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else
            {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
