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
    }
    
    public void testSolutionA()
    {
        solution = new SolutionA();
        assertSolution();
    }
    
    private void assertSolution()
    {
        assertEquals(6, solution.maxProfit(new int[] {3, 3, 5, 0, 0, 3, 1, 4}));
        assertEquals(4, solution.maxProfit(new int[] {1, 2, 3, 4, 5}));
        assertEquals(0, solution.maxProfit(new int[] {7, 6, 4, 3, 1}));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
