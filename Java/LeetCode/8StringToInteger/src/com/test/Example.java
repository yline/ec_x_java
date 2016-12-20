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
        assertEquals(0, solution.myAtoi(null));
        assertEquals(0, solution.myAtoi(""));
        assertEquals(-1, solution.myAtoi("-1"));
        assertEquals(1, solution.myAtoi("1"));
        assertEquals(100, solution.myAtoi("100"));
        assertEquals(1, solution.myAtoi("1-1"));
        assertEquals(10, solution.myAtoi("   010"));
        assertEquals(10, solution.myAtoi("   +010"));
        assertEquals(0, solution.myAtoi("   +-010"));
        assertEquals(-2147483648, solution.myAtoi("-2147483648"));
        assertEquals(2147483647, solution.myAtoi("123456789098765431"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
