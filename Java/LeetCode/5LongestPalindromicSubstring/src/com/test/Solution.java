package com.test;

public class Solution
{
    /** 时间复杂度,超了 */
    public String longestPalindrome(String s)
    {
        String content = s.charAt(0) + "";
        for (int i = s.length(); i > 0; i--)
        {
            for (int j = 0; j <= s.length() - i; j++)
            {
                content = s.substring(j, j + i);
                if (isPalindromeString(content))
                {
                    return content;
                }
            }
        }
        return content;
    }
    
    // 这个里面有一个循环,因此复杂度算n
    public boolean isPalindromeString(String str)
    {
        StringBuffer stringBuffer = new StringBuffer(str);
        String reverse = stringBuffer.reverse().toString();
        return str.equals(reverse);
    }
    
    /** 官网提供的answer */
    public String longestPalindrome2(String s)
    {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++)
        {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start)
            {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right)
    {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R))
        {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
