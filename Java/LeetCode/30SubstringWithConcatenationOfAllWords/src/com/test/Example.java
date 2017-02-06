package com.test;

import java.util.ArrayList;
import java.util.List;

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
        String s1 = "barfoothefoobarman";
        String[] word1 = new String[] {"foo", "bar"};
        List<Integer> result1 = new ArrayList<>();
        result1.add(0);
        result1.add(9);
        assertEquals(result1.toString(), solution.findSubstring(s1, word1).toString());
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
