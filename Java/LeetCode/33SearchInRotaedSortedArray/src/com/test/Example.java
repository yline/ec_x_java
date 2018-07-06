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
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        int[] array2 = {4, 5, 6, 7, 8, 1, 2, 3};
        int[] array3 = {8, 1};
        int[] array4 = {1, 3};
        
        assertEquals(4, solution.binarySearchIndex(array));
        assertEquals(5, solution.binarySearchIndex(array2));
        assertEquals(1, solution.binarySearchIndex(array3));
        assertEquals(0, solution.binarySearchIndex(array4));
        
        assertEquals(4, solution.search(array, 0));
        assertEquals(-1, solution.search(array, 3));
        assertEquals(-1, solution.search(array3, 0));
        assertEquals(0, solution.search(array4, 1));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
