package com.test.base;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private SolutionA solution;
    
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
        assertEquals(1, solution.minCut("aab"));
        assertEquals(1, solution.minCut("aaab"));
        assertEquals(1, solution.minCut("aaaab"));
        assertEquals(1, solution.minCut("aaaaab"));
        assertEquals(1, solution.minCut("aaaaaabbbbbbb"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
