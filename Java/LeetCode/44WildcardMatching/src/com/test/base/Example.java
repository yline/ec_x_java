package com.test.base;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
        solution = new SolutionA();
    }
    
    public void testSolution()
    {
        assertEquals(false, solution.isMatch("aa", "a"));
        assertEquals(true, solution.isMatch("aa", "*"));
        assertEquals(false, solution.isMatch("cb", "?a"));
        assertEquals(true, solution.isMatch("adceb", "*a*b"));
        assertEquals(false, solution.isMatch("acdcb", "a*c?b"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
