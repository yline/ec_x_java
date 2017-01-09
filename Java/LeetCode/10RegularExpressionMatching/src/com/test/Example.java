package com.test;

import junit.framework.TestCase;

/**
 * 
'.' Matches any single character. // 单独匹配任何一个字符
'*' Matches zero or more of the preceding element. // 选择匹配 前一个的单词,零个或多个

The matching should cover the entire input string (not partial).

 * @author YLine
 *
 * 2016年12月25日 下午4:52:40
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
        // assertEquals(true, solution.isMatch("aa", "*a")); 数组越界
        assertEquals(true, solution.isMatch("aa", "*aa"));
        assertEquals(true, solution.isMatch("aa", "aa"));
        assertEquals(false, solution.isMatch("aaa", "aa"));
        assertEquals(true, solution.isMatch("aa", "a*"));
        assertEquals(true, solution.isMatch("aa", ".*"));
        assertEquals(true, solution.isMatch("ab", ".*"));
        assertEquals(true, solution.isMatch("aab", "aab"));
        assertEquals(true, solution.isMatch("aab", "*.*"));
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
