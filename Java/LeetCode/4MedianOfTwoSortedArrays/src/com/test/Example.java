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
        //        assertEquals(0, solution.lengthOfLongestSubstring(""));
        //        
        //        assertEquals(1, solution.lengthOfLongestSubstring("c"));
        //        
        //        assertEquals(2, solution.lengthOfLongestSubstring("cv"));
        //        
        //        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        //        
        //        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
        //        
        //        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
