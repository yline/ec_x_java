package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

/**
 * KMP算法
 * 
 * @author YLine
 *
 * 2018年12月12日 上午11:01:22
 */
public class SolutionA implements Solution
{
    private static final int LENGTH = 10;
    
    @Override
    public List<String> findRepeatedDnaSequences(String s)
    {
        if (s.length() <= LENGTH)
        {
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
        
        int[] next = next(s); // 计算快速移动的偏移
        boolean[] sign = new boolean[s.length()]; // 记录遍历过的true
        
        int index = 0;
        final int length = s.length() - LENGTH;
        while (index < length)
        {
            if (sign[index])
            {
                index++;
                continue;
            }
            
            boolean isMatch = signArray(s, next, sign, index + 1, index);
            if (isMatch)
            {
                result.add(s.substring(index, index + LENGTH));
            }
            index++;
        }
        
        return result;
    }
    
    private boolean signArray(String haystack, int[] next, boolean[] sign, int hayStart, int start)
    {
        boolean isMatch = false;
        
        int hayIndex = hayStart, needIndex = 0;
        while (hayIndex < haystack.length() && needIndex < LENGTH)
        {
            if (haystack.charAt(hayIndex) == haystack.charAt(start + needIndex))
            {
                hayIndex++;
                needIndex++;
                if (needIndex == LENGTH) // 所有符合条件的，都设置为true
                {
                    isMatch = true;
                    sign[hayIndex - needIndex] = true;
                    
                    needIndex = 0;
                    hayIndex = hayIndex - needIndex + 1; // 回到第二个
                }
            }
            else
            {
                if (needIndex == 0)
                {
                    hayIndex++;
                    needIndex = next[needIndex];
                }
                else
                {
                    needIndex = next[needIndex];
                }
            }
        }
        
        return isMatch;
    }
    
    private static final int TAG = -5;
    
    /**
     * A --> {0}
     * AB --> {0, 0}
     * aabaaac --> {0, 0, 1, 0, 1, 2, 2}
     * ABCDABDABAB --> {0, 0, 0, 0, 0, 1, 2, 0, 1, 2, 1}
     * SSSSSSSSSSS --> {0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
     * 
     * @param needle 字符串
     * @return 如果当前位置，不匹配，可以移动的距离
     */
    public static int[] next(String needle)
    {
        int[] next = new int[needle.length()];
        
        next[0] = TAG;
        int k = TAG;
        int index = 0;
        while (index < needle.length() - 1)
        {
            if (k == TAG)
            {
                index++;
                k = 0;
                next[index] = 0;
            }
            else if (needle.charAt(k) == needle.charAt(index))
            {
                index++;
                k++;
                next[index] = k;
            }
            else
            {
                k = next[k];
            }
        }
        
        next[0] = 0;
        return next;
    }
}
