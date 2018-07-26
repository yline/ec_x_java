package com.test;

import java.util.Arrays;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    @Override
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
}
