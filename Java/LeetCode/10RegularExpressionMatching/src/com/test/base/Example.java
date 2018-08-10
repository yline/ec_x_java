package com.test.base;

import com.test.SolutionC;

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
    
    //    public void testSolutionA()
    //    {
    //        solution = new SolutionA();
    //        assertSolution();
    //    }
    
    public void testSolutionB()
    {
        //        solution = new SolutionB();
        //        assertSolution();
    }
    
    public void testSolutionC()
    {
        solution = new SolutionC();
        
        boolean isMatch = solution.isMatch("112233", "1*.*");
        System.out.println(isMatch);
        
        //        assertSolution();
    }
    
    private void assertSolution()
    {
        //        assertEquals(false, solution.isMatch("aa", "*a")); // 数组越界
        //        assertEquals(false, solution.isMatch("aa", "*aa"));
        //        assertEquals(false, solution.isMatch("aab", "*.*"));
        
        assertEquals(true, solution.isMatch("eqwfdasfda", ".*"));
        assertEquals(false, solution.isMatch("dasfewqrddasfd", ".*dd"));
        assertEquals(true, solution.isMatch("erqwdsafd", ".*"));
        assertEquals(true, solution.isMatch("123fda", ".*"));
        assertEquals(true, solution.isMatch("123fda", ".***"));
        assertEquals(false, solution.isMatch("111111111111112", "1***"));
        assertEquals(true, solution.isMatch("111111111111112", "1**.*"));
        
        assertEquals(false, solution.isMatch("aa", "a"));
        assertEquals(true, solution.isMatch("aa", "aa"));
        assertEquals(false, solution.isMatch("aaa", "aa"));
        assertEquals(true, solution.isMatch("aa", "a*"));
        assertEquals(true, solution.isMatch("aa", ".*"));
        assertEquals(true, solution.isMatch("ab", ".*"));
        assertEquals(true, solution.isMatch("aab", "aab"));
        assertEquals(true, solution.isMatch("aaaaaaaaaaaaaaaaaccdb", ".*"));
        assertEquals(true, solution.isMatch("aaaaaaaaaaaaaaaaaccdb", "c*a.*db"));
        assertEquals(true, solution.isMatch("aaaaaaaaaaaaaaaaadccdb", "c*aaa.*db"));
        assertEquals(true, solution.isMatch("aa", "aa"));
        
        assertEquals(true, solution.isMatch("aab", "c*a*b"));
        assertEquals(false, solution.isMatch("aa", "aaa"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}