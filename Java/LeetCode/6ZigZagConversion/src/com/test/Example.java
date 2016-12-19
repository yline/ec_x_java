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
        assertEquals("", solution.convert("", 1));
        assertEquals("", solution.convert("", 2));
        assertEquals("", solution.convert("", 3));
        
        assertEquals("ABCDEFGHIJKLMN", solution.convert("ABCDEFGHIJKLMN", 1));
        assertEquals("ACEGIKMBDFHJLN", solution.convert("ABCDEFGHIJKLMN", 2));
        assertEquals("AEIMBDFHJLNCGK", solution.convert("ABCDEFGHIJKLMN", 3));
        assertEquals("AGMBFHLNCEIKDJ", solution.convert("ABCDEFGHIJKLMN", 4));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}