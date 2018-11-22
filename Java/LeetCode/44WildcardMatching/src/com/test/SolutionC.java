package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

/**
 * 在SolutionB上改进
 * 函数f(s, sIndex, pArray, pIndex)
 * 
 * 当p(pIndex) == *时，
 * 计算下一个偏移量 diff = function(s, sIndex, pArray[pIndex+1])
 * = f(s, sIndex+diff, p, pIndex) || f(s, sIndex, pArray, pIndex+1)
 * 
 * 当p(pIndex) == *时，
 * segment = pArray[pIndex]
 * = s(sIndex+segment.length) == pArray(pIndex) && f(s, sIndex+segment.length, pArray, pIndex)
 * 
 * 优化点：解决片段移动速度缓慢的问题
 * 运行还是超时：261.278s
 * 
 * @author YLine
 *
 * 2018年11月22日 下午3:44:54
 */
public class SolutionC implements Solution
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
                if (pIndex + 1 == pArray.length) // 倒数第二个是 * 则直接成功
                {
                    return true;
                }
                else
                {
                    int diff = fastMove(s, sIndex, pArray[pIndex + 1]);
                    if (diff == -1)
                    {
                        return dfs(s, sIndex, pArray, pIndex + 1);
                    }
                    return dfs(s, sIndex, pArray, pIndex + 1) || dfs(s, sIndex + diff, pArray, pIndex);
                }
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
     * @return 偏移量
     */
    public int fastMove(String s, int sIndex, String pSegment)
    {
        int remainder = s.length() - pSegment.length() + 1;
        for (int i = sIndex + 1; i < remainder; i++)
        {
            boolean isBreak = false;
            for (int j = 0; j < pSegment.length(); j++)
            {
                if (s.charAt(i + j) != pSegment.charAt(j) && SINGLE != pSegment.charAt(j))
                {
                    isBreak = true;
                    break;
                }
            }
            
            if (!isBreak)
            {
                return i - sIndex;
            }
        }
        
        return -1;
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
