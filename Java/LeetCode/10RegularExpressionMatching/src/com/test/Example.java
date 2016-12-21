package com.test;

import junit.framework.TestCase;

/**
 * 严重怀疑正确answer
 */
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
        assertEquals(false, solution.isMatch("aa", "a"));
        assertEquals(true, solution.isMatch("aa", "aa"));
        assertEquals(false, solution.isMatch("aaa", "aa"));
        assertEquals(true, solution.isMatch("aa", "a*"));
        assertEquals(true, solution.isMatch("aa", ".*"));
        assertEquals(true, solution.isMatch("ab", ".*"));
        assertEquals(true, solution.isMatch("aab", "c*a*b"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
