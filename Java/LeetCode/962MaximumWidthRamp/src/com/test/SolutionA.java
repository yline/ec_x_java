package com.test;

/**
 * Given an array A of integers, a ramp[斜坡] is a tuple[组] (i, j) for which i < j and A[i] <= A[j].
 * 
 * 给一个整数数组，一个连接是一组，如果是递增的（i < j时，有A[i] <= A[j]）
 * 
 * The width of such a ramp is j - i.
 * 斜坡的宽度 = j - i
 * 
 * Find the maximum width of a ramp in A.  If one doesn't exist, return 0.
 * 求，数组A中，最大的斜坡宽度，如果不存在，则返回0
 * 
 * 案例：
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：0 < 5; 下标 = 5 - 1 = 4
 * 
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：第一个1，和最后一个1;
 * 
 * 思路：
 * 
 * 
 * @author YLine
 *
 * 2019年5月29日 下午7:34:10
 */
public class SolutionA
{
    public int maxWidthRamp(int[] A)
    {
        int left = 0;
        for (int i = 1; i < A.length; i++)
        {
            if (A[i - 1] > A[i]) // 一直是递减
            {
                continue;
            }
            
            left = i - 1;
            break;
        }
        
        // 如果一直是，单调递减的，则表示没有满足项
        if (left == 0)
        {
            return 0;
        }
        


        return 0;
    }
}
