package com.test;

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
