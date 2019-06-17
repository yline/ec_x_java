package com.test.base;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Example extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testSolutionA()
    {
        assertSolution();
    }
    
    private void assertSolution()
    {
        SolutionA solution = new SolutionA();
        String resultA = solution.shortestCommonSupersequence("abac", "cab");
        System.out.println(resultA);
        
        String resultB = solution.shortestCommonSupersequence("bbbaaaba", "bbababbb");
        System.out.println(resultB);
        
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
