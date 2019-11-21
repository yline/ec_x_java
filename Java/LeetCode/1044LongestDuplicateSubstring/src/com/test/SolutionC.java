package com.test;

import com.test.base.Solution;

/**
 * https://www.acwing.com/solution/leetcode/content/4699/
 * 
 * 1，假设最大的长度为a，则比它大的长度，一定是没有结果的；因此，可以用二分法，求出这个a。
 * 
 * 2，固定长度，则移动1位，利用hash求值，避免全部比较。
 * 
 * 
 * 
 * 
 * @author YLine
 *
 * 2019年11月21日 下午6:00:19
 */
public class SolutionC implements Solution
{
    private static final int mod = 999983;
    
    @Override
    public String longestDupSubstring(String S)
    {
        int[] power = new int[S.length()];
        power[0] = 1;
        for (int i = 1; i < S.length(); i++)
        {
            power[i] = power[i - 1] * 27 % mod;
        }
        
        int left = 0, right = S.length() - 1;
        while (left < right)
        {
            int mid = (left + right) >>> 1;
            if (check(S, mid + 1, power[mid]) == null)
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        
        if (left == 0)
        {
            return "";
        }
        
        new String().hashCode();
        
        return null;
    }
    
    private String check(String S, int left, int power)
    {
        int hash = 0;
        for (int i = 0; i < left; i++)
        {
            hash = (hash * 27 + S.charAt(i) - 'a' + 1) % mod;
        }
        
        // vis[hash].push_back(0);
        for (int i = left; i < S.length(); i++)
        {
            hash = (hash - power * (S.charAt(i - left) - 'a' + 1) % mod + mod) % mod;
            hash = (hash * 27 + S.charAt(i) - 'a' + 1) % mod;
            /*
            if (!vis[hash].empty() && cmp(s, vis[hash], i - len + 1, len))
                return s.substr(i - len + 1, len);
            
            vis[hash].push_back(i - len + 1);*/
        }
        
        return null;
    }
    
    private boolean cmp(String S)
    {
        /*for (int st : c) 多个相同的hash
        {
            // 全等遍历
            boolean flag = true;
            for (int i = st, j = x; i < st + len; i++, j++)
                if (s[i] != s[j])
                {
                    flag = false;
                    break;
                }
            if (flag)
                return true;
        }*/
        return false;
    }
}
