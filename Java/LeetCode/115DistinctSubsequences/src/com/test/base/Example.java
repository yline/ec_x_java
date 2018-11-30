package com.test.base;

import com.test.SolutionA;
import com.test.SolutionB;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testSolutionA()
    {
        solution = new SolutionA();
        assertSolution();
    }
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        assertSolution();
    }
    
    public void testSolutionC()
    {
        for (int i = 40; i < 50; i++)
        {
            System.out.println("i = " + i + ", result = " + dfs(i));
        }
    }
    
    private int dfs(int n)
    {
        if (n == 1 || n == 2)
        {
            return n;
        }
        return dfs(n - 2) + dfs(n - 1);
    }
    
    private void assertSolution()
    {
        assertEquals(3, solution.numDistinct("rabbbit", "rabbit"));
        assertEquals(5, solution.numDistinct("babgbag", "bag"));
        
        String sA =
            "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
        String tA = "bcddceeeebecbc";
        int resultA = solution.numDistinct(sA, tA);
        System.out.println("resultA = " + resultA);
        assertEquals(700531452, resultA);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
