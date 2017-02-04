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
        String haystack0 = "";
        String needle0 = "";
        assertEquals(0, solution.strStr(haystack0, needle0));
        
        String haystack1 = "nibicongqiankuaile";
        String needle1 = "ni";
        assertEquals(0, solution.strStr(haystack1, needle1));
        
        String haystack2 = "nibicongqiankuaile";
        String needle2 = "qiankuaile";
        assertEquals(8, solution.strStr(haystack2, needle2));
        
        String haystack3 = "nibicongqiankuaile";
        String needle3 = "cao";
        assertEquals(-1, solution.strStr(haystack3, needle3));
        
        String haystack4 = "nibicongqiankuaile";
        String needle4 = "y";
        assertEquals(-1, solution.strStr(haystack4, needle4));
        
        String haystack5 = "mississippi";
        String needle5 = "issip";
        assertEquals(4, solution.strStr(haystack5, needle5));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
