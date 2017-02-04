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
        int[] array1 = new int[] {1, 1, 2};
        assertEquals(2, solution.removeDuplicates(array1));
        
        int[] array2 = new int[] {};
        assertEquals(0, solution.removeDuplicates(array2));
        
        int[] array3 = new int[] {1, 1, 2, 3, 4, 4, 5};
        assertEquals(5, solution.removeDuplicates(array3));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
