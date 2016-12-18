package com.pacakge;

public class Solution
{
    public void testIf()
    {
        int i = 0;
        if (i == 1)
        {
            System.out.println("If -> 0");
            System.out.println("If -> 1");
        }
        
        System.out.println("If -> 2");
    }
    
    public void testFor1()
    {
        String[] strs = new String[] {"a", "b", "c"};
        for (String str : strs)
        {
            System.out.println("For1 -> " + str);
        }
    }
    
    public void testFor2()
    {
        String[] strs = new String[] {"a", "b", "c"};
        for (int i = 0; i < strs.length; i++)
        {
            System.out.println("For2 -> " + strs[i]);
        }
    }
    
    public void testWhile()
    {
        int i = 10;
        while (i > 0)
        {
            i--;
            System.out.println("While -> " + i);
        }
    }
}
