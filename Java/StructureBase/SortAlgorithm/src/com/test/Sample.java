package com.test;

import java.util.Arrays;

import junit.framework.TestCase;

public class Sample extends TestCase
{
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        solution = new Solution();
        super.setUp();
    }
    
    public void testSort()
    {
        System.out.println(Arrays.toString(solution.sortQuick()));
        System.out.println(Arrays.toString(solution.sortBubble()));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
