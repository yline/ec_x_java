package com.test;

import com.test.dynamic.EditDistance;
import com.test.dynamic.Knapsack;
import com.test.dynamic.ShortestPath;

import junit.framework.TestCase;

public class DynamicSample extends TestCase
{
    // 莱文斯距离
    public void testLevenDistance()
    {
        EditDistance.levenDistance("mitcmu", "mtacnu", 3);
        EditDistance.levenDistance("Then why do we buy", "We should", 14);
        EditDistance.levenDistance("Then why do we buy albums", "We should just spend all our money on gifts", 34);
    }
    
    // 最长公共字符串
    public void testLongestLength()
    {
        EditDistance.longestLength("mitcmu", "mtacnu", 4);
        EditDistance.longestLength("Then why do we buy", "We should", 5);
        EditDistance.longestLength("Then why do we buy albums", "We should just spend all our money on gifts", 12);
    }
    
    // 最短路径
    public void testShortestPath()
    {
        int[][] arrayA = {{1, 2, 3}, {1, 2, 3}};
        assertShortestPath(arrayA, 7);
        
        int[][] arrayB = {{0, 2, 3, 5, 6, 7, 8}, {2, 5, 3, 1, 2, 2, 2}
            , {2, 5, 3, 1, 2, 2, 2}, {2, 5, 3, 1, 2, 2, 2}, {2, 5, 3, 1, 2, 2, 2}
            , {2, 1, 3, 1, 2, 2, 2}, {2, 0, 3, 1, 2, 2, 2}, {2, 5, 3, 1, 2, 9, 2}};
        assertShortestPath(arrayB, 22);
        
        int[][] arrayC = {{0, 2, 3, 5, 6, 7, -20}, {2, 5, 3, 1, 2, 2, 2}, {2, 5, 3, 1, 2, 2, 2}, {2, 5, 3, 1, 2, 2, 2},
            {2, 5, 3, 1, 2, 2, 2}, {2, 1, 3, 1, 2, 2, 2}, {2, 0, 3, 1, 2, 2, 2}, {2, 5, 3, 1, 2, 9, 2}};
        assertShortestPath(arrayC, 17);
    }
    
    /**
     * 最短路径
     * @param array 二维
     * @param result 最短路径的结果值
     */
    private void assertShortestPath(int[][] array, int result)
    {
        int backtrack = ShortestPath.backtrack(array);
        int dynamic = ShortestPath.dynamic(array);
        assertEquals(backtrack, result);
        assertEquals(dynamic, result);
    }
    
    /**
     * 01背包问题，仅重量，无价值变量
     */
    public void testKnapsack()
    {
        int[] valueArrayA = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(9, Knapsack.dynamic(valueArrayA, 9));
        assertEquals(45, Knapsack.dynamic(valueArrayA, 45));
        assertEquals(45, Knapsack.dynamic(valueArrayA, 100));
    }
    
    /**
     * 01背包问题，有重量，有价值变量
     */
    public void testknapsack()
    {
        
    }
}
