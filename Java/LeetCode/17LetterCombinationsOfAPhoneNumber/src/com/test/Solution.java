package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution
{
    public List<String> letterCombinations(String digits)
    {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < digits.length(); i++)
        {
            result = compileLetter(result, getContent(digits.charAt(i)));
            System.out.println(result.toString());
        }
        
        return result;
    }
    
    private List<String> compileLetter(List<String> tempList, String str)
    {
        List<String> result = new ArrayList<>();
        
        if (tempList.size() == 0)
        {
            for (int j = 0; j < str.length(); j++)
            {
                result.add(str.charAt(j) + "");
            }
        }
        else
        {
            for (int i = 0; i < tempList.size(); i++)
            {
                for (int j = 0; j < str.length(); j++)
                {
                    result.add(tempList.get(i) + str.charAt(j));
                }
            }
        }
        
        return result;
    }
    
    private String getContent(char c)
    {
        String result = "";
        switch (c)
        {
            case '2':
                result = "abc";
                break;
            case '3':
                result = "def";
                break;
            case '4':
                result = "ghi";
                break;
            case '5':
                result = "jkl";
                break;
            case '6':
                result = "mno";
                break;
            case '7':
                result = "pqrs";
                break;
            case '8':
                result = "tuv";
                break;
            case '9':
                result = "wxyz";
                break;
            default:
                break;
        }
        return result;
    }
    
    private String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz",};
    
    private List<String> result; // 存储最终结果
    
    private char[] chars; // 保存去掉0，1字符的结果
    
    private char[] curResult; // 存储中间结果
    
    private int end = 0; // 字符数组中的第一个未使用的位置
    
    private int handle = 0; // 当前处理的是第几个字符数字
    
    /**
     * <pre>
     * 原题
     * Given a digit string, return all possible letter combinations that the number could represent.
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     *
     * Input:Digit string "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     *
     * Note: Although the above answer is in lexicographical order, your answer
     * could be in any order you want.
     *
     * 题目大意
     * 给定一个数字串，返回数字上所有字符的所有组合，数字到字符的映射如上图所示。
     * 注意： 尽管上面的结果以字符顺序排列的，你可以以任何顺序返回结果。
     *
     * 解题思路
     * 用一个数组保存数字和字的映射关系，根据数字串的输入，找到对应的字符，组合结果。
     * </pre>
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits)
    {
        result = new LinkedList<>();
        
        if (digits != null && digits.length() > 0)
        {
            
            chars = digits.toCharArray();
            
            // 对字符串进行处理，去掉0和1
            // 找第一个0或者1的位置
            while (end < digits.length() && chars[end] != '0' && chars[end] != '1')
            {
                end++;
            }
            
            handle = end + 1;
            while (handle < chars.length)
            {
                if (chars[handle] != '0' && chars[handle] != '1')
                {
                    chars[end] = chars[handle];
                    end++;
                }
                handle++;
            }
            
            curResult = new char[end];
            // while结束后，end为有效字符的长度
            handle = 0; // 指向第一个有效字符的位置
            
            letterCombinations();
        }
        return result;
    }
    
    private void letterCombinations()
    {
        if (handle >= end)
        {
            result.add(new String(curResult));
        }
        else
        {
            int num = chars[handle] - '2';
            for (int i = 0; i < map[num].length(); i++)
            {
                curResult[handle] = map[num].charAt(i);
                handle++;
                letterCombinations();
                handle--;
            }
        }
    }
}
