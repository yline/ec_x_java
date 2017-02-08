package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution
{
    /**
     * You are given a string, s, and a list of words, words, that are all of the same length.
     * 
     * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters
     * 
     * For example, given:
     * s: "barfoothefoobarman"
     * 
     * words: ["foo", "bar"]
     * 
     * You should return the indices: [0,9].
     * 
     * 自己写的方案 单元测试过了,但是 测试时运行超时
     * 
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words)
    {
        List<Integer> result = new ArrayList<>();
        
        // 特殊情况判断
        if (null == words || null == s)
        {
            return result;
        }
        
        if (words.length == 0)
        {
            for (int i = 0; i < s.length(); i++)
            {
                result.add(i);
            }
            return result;
        }
        
        if (s.length() < words[0].length())
        {
            return result;
        }
        
        boolean isTrue;
        int temp = -1;
        List<Integer> tempList;
        
        // 开始循环
        for (int i = 0; i < s.length() - words.length * words[0].length() + 1; i++)
        {
            tempList = new ArrayList<>();
            isTrue = true;
            for (int j = 0; j < words.length; j++)
            {
                temp = isContain(i + tempList.size() * words[0].length(), s, words, tempList);
                if (temp != -1)
                {
                    tempList.add(temp);
                }
                else
                {
                    isTrue = false;
                    break;
                }
            }
            
            if (isTrue)
            {
                result.add(i);
            }
        }
        
        System.out.println(result.toString());
        
        return result;
    }
    
    /**
     * 不考虑意外情况,判断是否 符合要求
     * @param start stack开始的位置
     * @param stack 目标字符串
     * @param words 字符串组
     * @param exp words中不遍历的位置
     * @return 相同则返回位置,否则-1
     */
    public int isContain(int start, String stack, String[] words, List<Integer> expList)
    {
        for (int i = 0; i < words.length; i++)
        {
            if (isContain(i, expList))
            {
                continue;
            }
            
            if (words[i].equals(stack.substring(start, start + words[i].length())))
            {
                return i;
            }
        }
        return -1;
    }
    
    private boolean isContain(int i, List<Integer> expList)
    {
        for (Integer integer : expList)
        {
            if (i == integer)
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 这是google给的答案,思路一致
     * @param S
     * @param L
     * @return
     */
    public static List<Integer> findSubstring2(String S, String[] L)
    {
        List<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0)
            return res;
        int len = L[0].length(); // length of each word
        
        Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
        for (String w : L)
            map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        
        for (int i = 0; i <= S.length() - len * L.length; i++)
        {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < L.length; j++)
            { // checkc if match
                String str = S.substring(i + j * len, i + j * len + len); // next word
                if (copy.containsKey(str))
                { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1)
                        copy.remove(str);
                    else
                        copy.put(str, count - 1);
                    if (copy.isEmpty())
                    { // matches
                        res.add(i);
                        break;
                    }
                }
                else
                    break; // not in L
            }
        }
        return res;
    }
    
}
