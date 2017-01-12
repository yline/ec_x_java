package com.test;

import java.util.ArrayList;
import java.util.List;

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
        int[] array1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result1 = new ArrayList<>();
        result1.add(solution.getList(-1, 0, 1));
        result1.add(solution.getList(-1, -1, 2));
        assertEquals(result1, solution.threeSum(array1));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
