package com.test;

import java.util.List;

/**
 * Given a list of words (without duplicates),
 * 给一串没有相同字符的字符组
 * please write a program that returns all concatenated words in the given list of words.
 * 实现一个算法，返回列表中完全由其它字符组成的字符
 * 
 * A concatenated word is defined as a string
 * 由其它字符组成的字符含义是
 * that is comprised entirely of at least two shorter words in the given array.
 * 该字符，是列表中其它两个以上(包含两个)的字符，组成
 * 
 * Example:
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 
 * Note:
 * The number of elements of the given array will not exceed 10,000
 * The length sum of elements in the given array will not exceed 600,000.
 * All the input string will only include lower case letters.
 * The returned elements order does not matter.
 * 
 * 1，先按字符长短排序，短->长
 * 2，Tree结构整成；一个个的添加(独立的，则加入，否则加入)
 * 
 * @author YLine
 *
 * 2019年8月12日 下午2:14:23
 */
public class SolutionA
{
    
    public List<String> findAllConcatenatedWordsInADict(String[] words)
    {
        return null;
    }
}
