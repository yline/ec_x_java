package com.test;

import java.util.Arrays;

/**
 * Given four lists A, B, C, D of integer values, 
 * compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * 给4个数组，计算A[i] + B[j] + C[k] + D[l] == 0，组合的个数
 * 
 * To make problem a bit easier, 
 * all A, B, C, D have same length of N where 0 ≤ N ≤ 500. // 长度为 0-500之间
 * All integers are in the range of -2^28 to 2^28 - 1  // 单个值在-2^28和2^28-1 之间
 * and the result is guaranteed to be at most 2^31 - 1. // 4个值，结果不超过int的最大值
 * 
 * 思路：
 * 1，四个数组分别排序，将最小值相加，得到某个值，必须要小于等于0
 * 2，选择，四个数组中，当前值和下一个值差额最小的进行移动。？？？？
 * 
 * @author YLine
 *
 * 2019年10月26日 下午6:30:24
 */
public class SolutionA
{
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        
        return 0;
    }
}
