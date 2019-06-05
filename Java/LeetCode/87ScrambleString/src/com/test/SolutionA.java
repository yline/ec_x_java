package com.test;

/**
 * Given a string s1, we may represent it as a binary tree
 * by partitioning it to two non-empty substrings recursively.
 * 
 * 给一个字符串，可以分割为两个“非空”字符串
 * 
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * 为了争夺字符串，可以将其中的子字符串，翻转
 * 
 * For example, if we choose the node "gr" and swap its two children,
 * it produces a scrambled string "rgeat".
 * 例如：将gr翻转，得到 rgeat
 * 
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at",
 * it produces a scrambled string "rgtae".
 * 
 * 相似的，可以翻转多个，将great翻转为rgtae
 * 
 * Given two strings s1 and s2 of the same length,
 * determine if s2 is a scrambled string of s1.
 * 给两个字符串，判断他们是否可以通过翻转得到彼此
 * 
 * 思路：从前往后遍历，利用回文的方式，判断
 * 
 * @author YLine
 *
 * 2019年6月5日 下午5:57:26
 */
public class SolutionA
{
    public boolean isScramble(String s1, String s2)
    {
        return false;
    }
}
