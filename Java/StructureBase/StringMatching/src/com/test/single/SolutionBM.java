package com.test.single;

/**
 * BM（Boyer-Moore）算法，在不匹配时，找规律，让模式串多滑动几位
 * 
 * n : 主串长度
 * m : 模式串长度
 * 
 * 坏字符规则：（bad character rule）
 * 好后缀规则：（good suffix shift）
 * 
 * @author YLine
 *
 * 2019年3月26日 下午2:38:15
 */
public class SolutionBM implements SingleModelSolution
{
    
    @Override
    public int matching(String mainStr, String patternStr)
    {
        // 这个方法，是一个分发方法，不实现具体功能
        testGoodSuffix(mainStr, patternStr);
        
        testBadChar(mainStr, patternStr);
        
        testMerge(mainStr, patternStr);
        
        // 结果永远是 -1
        return -1;
    }
    
    // 单独，好后缀，实现
    private void testGoodSuffix(String mainStr, String patternStr)
    {
        /*SolutionBM solution = new SolutionBM();
        int[] resultA = solution.goodSuffix("cabcab".toCharArray());
        System.out.println(Arrays.toString(resultA));
        
        int[] resultB = solution.goodSuffix("acabab".toCharArray());
        System.out.println(Arrays.toString(resultB));
        
        int[] resultC = solution.goodSuffix("bcabab".toCharArray());
        System.out.println(Arrays.toString(resultC));
        
        int[] resultD = solution.goodSuffix("bbabbb".toCharArray());
        System.out.println(Arrays.toString(resultD));*/
    }
    
    // 单独，坏字符，实现
    private void testBadChar(String mainStr, String patternStr)
    {
        
    }
    
    // 坏字符和好后缀，合并实现
    private void testMerge(String mainStr, String patternStr)
    {
        
    }
}

