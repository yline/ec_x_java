package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

/**
 * 在SolutionC上改进
 * 使用非常暴力的手段
 * 
 * @author YLine
 *
 * 2018年11月22日 下午5:47:40
 */
public class SolutionD implements Solution
{
    private static final char SINGLE = '?';
    
    private static final char MULTIFY = '*';
    
    @Override
    public boolean isMatch(String s, String p)
    {
        List<String> pList = splitToArray(p);
        if (pList.isEmpty()) // 长度为 0
        {
            return s.isEmpty();
        }
        else if (pList.size() == 1) // 长度为1
        {
            if (MULTIFY == pList.get(0).charAt(0))
            {
                return true;
            }
            else
            {
                String pSegment = pList.get(0);
                if (s.length() == pSegment.length())
                {
                    for (int i = 0; i < s.length(); i++)
                    {
                        if (s.charAt(i) != pSegment.charAt(i) && pSegment.charAt(i) != SINGLE)
                        {
                            return false;
                        }
                    }
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else // 长度大于2的处理
        {
            int startOffset = 0;
            String pFirst = pList.get(0);
            if (MULTIFY != pFirst.charAt(0)) // 不带*的开头
            {
                if (s.length() >= pFirst.length())
                {
                    for (int i = 0; i < pFirst.length(); i++)
                    {
                        if (s.charAt(i) != pFirst.charAt(i) && pFirst.charAt(i) != SINGLE)
                        {
                            return false;
                        }
                    }
                }
                else
                {
                    return false;
                }
                
                startOffset = pFirst.length();
                pList.remove(0); // 第一个过关，则移除第一个
            }
            
            int endOffset = 0;
            String pLast = pList.get(pList.size() - 1);
            if (MULTIFY != pLast.charAt(0)) // 不带*的结尾
            {
                if (s.length() >= pLast.length())
                {
                    int diff = s.length() - pLast.length();
                    for (int i = pLast.length() - 1; i >= 0; i--)
                    {
                        if (s.charAt(i + diff) != pLast.charAt(i) && pLast.charAt(i) != SINGLE)
                        {
                            return false;
                        }
                    }
                }
                else
                {
                    return false;
                }
                
                endOffset = pLast.length();
                pList.remove(pList.size() - 1); // 最后一个过关，则移除最后一个
            }
            
            // 长度超过s
            if (startOffset + endOffset > s.length())
            {
                return false;
            }
            
            // 中间的状态了；不需要全等，只需要p的片段，全部依次存在在s中即可
            return isOrderExist(s, pList, startOffset, endOffset);
        }
    }
    
    private boolean isOrderExist(String s, List<String> pArray, int startOffset, int endOffset)
    {
        if (pArray.isEmpty())
        {
            return true;
        }
        
        int index = startOffset;
        for (int k = 0; k < pArray.size();)
        {
            String pSegment = pArray.get(k);
            if (MULTIFY != pSegment.charAt(0)) // 相等，则跳过
            {
                boolean isBreak = false;
                for (int i = 0; i < pSegment.length(); i++)
                {
                    if (i + index >= s.length() - endOffset)
                    {
                        return false;
                    }
                    
                    if (s.charAt(i + index) != pSegment.charAt(i) && SINGLE != pSegment.charAt(i))
                    {
                        isBreak = true;
                        break;
                    }
                }
                
                if (!isBreak)
                {
                    k++;
                    index += pSegment.length();
                }
                else
                {
                    index++;
                }
            }
            else
            {
                k++;
            }
        }
        
        return true;
    }
    
    /**
     * @param p 输入的格式参数； such as : {**a*a*a*a**}
     * @return 将内容与 * 进行分离；such as : {[*, a, *, a, *, a, *, a, *]}
     */
    private List<String> splitToArray(String p)
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
        return segmentList;
    }
}
