package com.test;

import junit.framework.TestCase;

public class Example extends TestCase
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
        int[] arrayA = {};
        assertEquals(0, solution.searchInsert(arrayA, 1));
        
        int[] arrayB = {1};
        assertEquals(0, solution.searchInsert(arrayB, 0));
        assertEquals(0, solution.searchInsert(arrayB, 1));
        assertEquals(1, solution.searchInsert(arrayB, 2));
        
        int[] arrayC = {1, 3, 5, 6};
        assertEquals(2, solution.searchInsert(arrayC, 5));
        assertEquals(1, solution.searchInsert(arrayC, 2));
        assertEquals(4, solution.searchInsert(arrayC, 7));
        assertEquals(0, solution.searchInsert(arrayC, 0));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
