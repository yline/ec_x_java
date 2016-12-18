package com.test.pps;

public class ClassScope
{
    private int id = 0;
    
    public void test()
    {
        int id = 10;
        System.out.println("ClassScope id = " + id);
    }
}
