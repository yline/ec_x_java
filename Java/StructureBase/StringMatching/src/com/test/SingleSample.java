package com.test;

import com.test.single.SolutionBF;
import com.test.single.SolutionBM;
import com.test.single.SolutionRK;

import junit.framework.TestCase;

public class SingleSample extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    // 测试 BF算法
    public void testBF()
    {
        SolutionBF solution = new SolutionBF();
        assertEquals(0, solution.matching("", ""));
        assertEquals(0, solution.matching("aaaaaaaaaaaaaaaaaaaa", "aaa"));
        assertEquals(20, solution.matching("bbbbbbbbbbbbbbbbbbbbaaa", "aaa"));
        assertEquals(20, solution.matching("ccccccccccccccccccccaaa", "aaa"));
        assertEquals(10, solution.matching("ccccccccccaaacccccccccc", "aaa"));
    }
    
    // 测试 RK算法
    public void testRK()
    {
        SolutionRK solution = new SolutionRK();
        assertEquals(0, solution.matching("", ""));
        assertEquals(0, solution.matching("aaaaaaaaaaaaaaaaaaaa", "aaa"));
        assertEquals(20, solution.matching("bbbbbbbbbbbbbbbbbbbbaaa", "aaa"));
        assertEquals(20, solution.matching("ccccccccccccccccccccaaa", "aaa"));
        assertEquals(10, solution.matching("ccccccccccaaacccccccccc", "aaa"));
    }
    
    // 测试 BM算法，好后缀计算
    public void testBMGoodSuffix()
    {
        SolutionBM solution = new SolutionBM();
        assertEquals(0, solution.matching("", ""));
        assertEquals(0, solution.matching("aaaaaaaaaaaaaaaaaaaa", "aaa"));
        assertEquals(20, solution.matching("bbbbbbbbbbbbbbbbbbbbaaa", "aaa"));
        assertEquals(20, solution.matching("ccccccccccccccccccccaaa", "aaa"));
        assertEquals(10, solution.matching("ccccccccccaaacccccccccc", "aaa"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
