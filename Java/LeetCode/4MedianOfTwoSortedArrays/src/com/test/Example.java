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
        int[] nums2 = new int[] {1, 7, 9, 10};
        int[] nums1 = new int[] {2, 8};
        
        assertEquals(7.5, solution.findMedianSortedArrays(nums1, nums2));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
