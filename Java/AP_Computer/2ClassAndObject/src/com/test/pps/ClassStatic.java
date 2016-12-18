package com.test.pps;

public class ClassStatic
{
    private static int staticNumber = 0;
    
    private int number = 0;
    
    public void print()
    {
        staticNumber += 1;
        number += 1;
        
        System.out.println("ClassStatic staticNumber = " + staticNumber);
        System.out.println("ClassStatic number = " + number);
    }
    
    public static void printStatic()
    {
        System.out.println("ClassStatic printStatic");
    }
}
