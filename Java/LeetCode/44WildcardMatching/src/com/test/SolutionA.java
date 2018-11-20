package com.test;

import com.test.base.Solution;

/**
 * 解题思路
 * 1，找出数学规律，每一位节点，先计算每个节点的值(其余的位数相乘，求加法)
 * 2，每个节点，进行求余，然后整合出完成的，每个节点范围在(0-9)之间
 * 3，将首位是否为0，判断；然后，拼凑成字符串
 * 
 * 时间复杂度
 * 测试：时间超时
 * 
 * @author YLine
 *
 * 2018年7月23日 下午4:25:13
 */
public class SolutionA implements Solution
{
    private static final char SINGLE = '?';
    
    private static final char MULTIFY = '*';
    
    @Override
    public boolean isMatch(String s, String p)
    {
        return dfs(s, 0, p, 0);
    }
    
    private boolean dfs(String s, int sIndex, String p, int pIndex)
    {
        if (pIndex == p.length())
        {
            if (sIndex == s.length())
            {
                return true;
            }
            return false;
        }
        
        if (MULTIFY == p.charAt(pIndex))
        {
            if (sIndex == s.length())
            {
                return dfs(s, sIndex, p, pIndex + 1);
            }
            else
            {
                int doubleMultipy = 0; // 连续的 * 的次数
                StringBuilder pBuilder = new StringBuilder(); // 到下一个 * 的字符串集合；或者到最后的集合
                for (int i = pIndex + 1; i < p.length(); i++)
                {
                    if (MULTIFY == p.charAt(i))
                    {
                        if (pBuilder.length() == 0)
                        {
                            doubleMultipy++;
                        }
                        else
                        {
                            break;
                        }
                    }
                    pBuilder.append(p.charAt(i));
                }
                
                // 匹配到的下一个位置
                int nextDistance = s.indexOf(pBuilder.toString(), sIndex);
                if (nextDistance == -1) // 未匹配到位置
                {
                    return false;
                }
                else
                {
                    return dfs(s, sIndex, p, pIndex + 1 + doubleMultipy) || dfs(s, nextDistance + 1, p, pIndex);
                }
            }
        }
        else
        {
            if (sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || SINGLE == p.charAt(pIndex)))
            {
                return dfs(s, sIndex + 1, p, pIndex + 1);
            }
            else
            {
                return false;
            }
        }
    }
}
