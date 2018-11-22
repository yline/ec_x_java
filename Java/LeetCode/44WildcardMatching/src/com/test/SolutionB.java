package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

/**
 * 在SolutionA上改进
 * 由于 * 和多个*效果一致，因此，p进行*分离；得到 pArray 和 pIndex；*和字符片段，必定是交迭出现
 * 
 * 当p(pIndex) == *时，= f(s, sIndex+1, p, pIndex) || f(s, sIndex, p, pIndex+1)
 * 当p(pIndex) == *时，
 * segment = pArray[pIndex]
 * = s(sIndex+segment.length) == pArray(pIndex) && f(s, sIndex+segment.length, p, pIndex)
 * 
 * 优化点：解决了多个*重复计算的问题
 * 
 * 测试时间超时；
 * 本机：371.645s
 * 
 * @author YLine
 *
 * 2018年11月22日 下午3:26:27
 */
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
            if (sIndex + segment.length() > s.length())
            {
                return false;
            }
            for (int i = 0; i < segment.length(); i++)
            {
                if (s.charAt(i + sIndex) != segment.charAt(i) && SINGLE != segment.charAt(i))
                {
                    return false;
                }
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
