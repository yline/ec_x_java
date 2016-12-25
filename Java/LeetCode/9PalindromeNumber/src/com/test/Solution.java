package com.test;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author YLine
 *
 * 2016年12月25日 下午2:34:27
 */
public class Solution
{
    public boolean isPalindrome(int x)
    {
        String str = x + "";
        StringBuffer stringBuffer = new StringBuffer(str);
        String result = stringBuffer.reverse().toString();
        return str.equals(result);
    }
}
