package com.test;

public class Debug
{
    public static void main(String[] args)
    {
        Example example = new Example();
        try
        {
            example.setUp();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        example.testSolution();
    }
}
