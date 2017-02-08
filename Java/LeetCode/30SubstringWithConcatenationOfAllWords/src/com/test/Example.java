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
        
        // 检测工具类
        assertEquals(true, solution.isContain(0, s1, word1, new ArrayList<>()) != -1);
        assertEquals(true, solution.isContain(3, s1, word1, new ArrayList<>()) != -1);
        assertEquals(true, solution.isContain(9, s1, word1, new ArrayList<>()) != -1);
        assertEquals(true, solution.isContain(12, s1, word1, new ArrayList<>()) != -1);
        assertEquals(false, solution.isContain(11, s1, word1, new ArrayList<>()) != -1);
        
        // 检测最终结果
        assertEquals(result1.toString(), solution.findSubstring(s1, word1).toString());
        
        String s2 = "wordgoodgoodgoodbestword";
        String[] word2 = new String[] {"word", "good", "best", "good"};
        List<Integer> result2 = new ArrayList<>();
        //result2.add(0);
        //result2.add(4);
        result2.add(8);
        //result2.add(12);
        //result2.add(16);
        assertEquals(result2.toString(), solution.findSubstring(s2, word2).toString());
        
        String s3 = "barfoofoobarthefoobarman";
        String[] word3 = new String[] {"bar", "foo", "the"};
        List<Integer> result3 = new ArrayList<>();
        result3.add(6);
        result3.add(9);
        result3.add(12);
        assertEquals(result3.toString(), solution.findSubstring(s3, word3).toString());
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
