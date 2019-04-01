package com.test.single;

import com.test.single.bm.BMGoodSuffix;

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
        int goodMatch = BMGoodSuffix.goodSuffixBm(mainStr, patternStr);
        /*
        int badMatch = BMBadChar.badCharBm(mainStr, patternStr);
        
        int mergeMatch = BMMerge.mergeBm(mainStr, patternStr);
        
        assertEquals(goodMatch, badMatch);
        assertEquals(goodMatch, mergeMatch);*/
        
        return goodMatch;
    }
    
    /**
     * .好后缀
     */
    public void testGoodSuffix()
    {
        
    }
}
