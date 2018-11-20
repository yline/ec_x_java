package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

public class SolutionB implements Solution
{
    private static final char SINGLE = '?';
    
    private static final char MULTIFY = '*';
    
    @Override
    public boolean isMatch(String s, String p)
    {
        String[] pArray = splitToArray(p);
        return dfs(s, 0, pArray, 0);
    }
    
    private boolean dfs(String s, int sIndex, String[] pArray, int pIndex)
    {
        if (pIndex == pArray.length)
        {
            if (sIndex == s.length())
            {
                return true;
            }
            return false;
        }
        
        if (MULTIFY == pArray[pIndex].charAt(0)) // 单独的字符串
        {
            if (sIndex == s.length())
            {
                return dfs(s, sIndex, pArray, pIndex + 1);
            }
            else
            {
                return dfs(s, sIndex, pArray, pIndex + 1) || dfs(s, sIndex + 1, pArray, pIndex);
            }
        }
        else // 片段
        {
            String segment = pArray[pIndex];
            for (int i = 0; i < segment.length(); i++)
            {
                if (sIndex + i < s.length())
                {
                    if (s.charAt(sIndex + i) == segment.charAt(i) || SINGLE == segment.charAt(i))
                    {
                        continue;
                    }
                }
                return false;
            }
            return dfs(s, sIndex + segment.length(), pArray, pIndex + 1);
        }
    }
    
    /**
     * @param p 输入的格式参数； such as : {**a*a*a*a**}
     * @return 将内容与 * 进行分离；such as : {[*, a, *, a, *, a, *, a, *]}
     */
    private String[] splitToArray(String p)
    {
        List<String> segmentList = new ArrayList<String>();
        
        int lastIndex = 0;
        for (int i = 0; i < p.length(); i++)
        {
            if (i == 0 && MULTIFY == p.charAt(i)) // 若 首个为 *
            {
                while (i + 1 < p.length() && MULTIFY == p.charAt(i + 1)) // 去除重复的 *
                {
                    i++;
                }
                
                segmentList.add(String.valueOf(MULTIFY));
                lastIndex = i + 1;
                continue;
            }
            
            if (MULTIFY == p.charAt(i)) // 若中途为 *
            {
                if (lastIndex != i)
                {
                    segmentList.add(p.substring(lastIndex, i));
                }
                
                while (i + 1 < p.length() && MULTIFY == p.charAt(i + 1)) // 去除重复的 *
                {
                    i++;
                }
                segmentList.add(String.valueOf(MULTIFY));
                lastIndex = i + 1;
                
                continue;
            }
            
            if (i == p.length() - 1) // 最后，结算一次
            {
                segmentList.add(p.substring(lastIndex, p.length()));
            }
        }
        
        String[] pArray = new String[segmentList.size()];
        return segmentList.toArray(pArray);
    }
}
