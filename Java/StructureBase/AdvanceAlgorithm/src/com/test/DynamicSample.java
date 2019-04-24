package com.test;

import com.test.dynamic.EditDistance;

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
}
