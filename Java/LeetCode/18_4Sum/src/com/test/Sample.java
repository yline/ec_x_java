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
        int[] array0 = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> result0 = new ArrayList<>();
        result0.add(solution.getList(-2, -1, 1, 2));
        result0.add(solution.getList(-2, 0, 0, 2));
        result0.add(solution.getList(-1, 0, 0, 1));
        
        assertEquals(result0, solution.fourSum(array0, 0));
        
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
