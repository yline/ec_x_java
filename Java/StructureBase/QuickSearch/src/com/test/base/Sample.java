package com.test.base;

import com.test.binary.SolutionBintraySearch;

import junit.framework.TestCase;

public class Sample extends TestCase
{
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        solution = new SolutionBintraySearch();
        super.setUp();
    }
    
    public void testEqual()
    {
        SolutionBintraySearch.setType(SolutionBintraySearch.TYPE_1);
        assertEquals(0, solution.bintraySearch(new int[] {1}, 1));
        assertEquals(1, solution.bintraySearch(new int[] {0, 1}, 1));
        assertEquals(1, solution.bintraySearch(new int[] {0, 1, 2}, 1));
        assertEquals(1, solution.bintraySearch(new int[] {0, 1, 2, 3, 4, 5}, 1));
        assertEquals(1, solution.bintraySearch(new int[] {0, 1, 3, 431, 432}, 1));
        assertEquals(1, solution.bintraySearch(new int[] {0, 1, 2, 234, 345, 456}, 1));
        assertEquals(1, solution.bintraySearch(new int[] {0, 1, 9, 3}, 1));
        assertEquals(-1, solution.bintraySearch(new int[] {0, 2, 9, 3}, 1));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
