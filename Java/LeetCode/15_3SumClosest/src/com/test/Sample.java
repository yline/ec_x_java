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
        int[] array1 = {-1, 2, 1, -4};
        assertEquals(2, solution.threeSumClosest(array1, 1));
        
        int[] array2 = {-1, 0, 1, 1, 55};
        assertEquals(2, solution.threeSumClosest(array2, 3));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
