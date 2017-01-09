package com.test;

import junit.framework.TestCase;

public class Sample extends TestCase
{
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
        solution = new Solution();
    }
    
    public void testSolution()
    {
        assertEquals(1, solution.romanToInt("I"));
        assertEquals(2, solution.romanToInt("II"));
        assertEquals(3, solution.romanToInt("III"));
        assertEquals(13, solution.romanToInt("XIII"));
        assertEquals(14, solution.romanToInt("XIV"));
        assertEquals(19, solution.romanToInt("XIX"));
        assertEquals(3999, solution.romanToInt("MMMCMXCIX"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
