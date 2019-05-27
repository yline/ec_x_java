package com.test.base;

import org.junit.Assert;

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
        int[] inputA = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] outputA = {0, 1, 0, 1, 0, 1, 0, 1};
        Assert.assertArrayEquals(outputA, solution.rearrangeBarcodes(inputA));
        
        int[] inputB = {1, 1, 1, 1, 2, 2, 3, 3};
        int[] outputB = {1, 3, 1, 3, 2, 1, 2, 1};
        Assert.assertArrayEquals(outputB, solution.rearrangeBarcodes(inputB));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
