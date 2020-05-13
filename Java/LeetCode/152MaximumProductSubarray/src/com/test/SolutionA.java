package com.test;


/**
 * Given an integer array nums,
 * find the contiguous subarray within an array (containing at least one number) 连续的子序列
 * which has the largest product. 乘积最大的值
 * 
 * 
Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 * 主要解决：
 * 1，0的问题，可以采用 分割的形式处理掉
 * 2，符号的问题，
 * 
 * @author YLine
 *
 * 2020年5月13日 下午5:55:59
 */
public class SolutionA
{
    public int maxProduct(int[] nums)
    {
        if (null == nums || nums.length == 0)
        {
            return 0;
        }
        
        if (nums.length == 1)
        {
            return nums[0];
        }
        
        int max = nums[0]; // 最大值
        int temp = nums[0]; // 临时计算的值
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
            {
                max = Math.max(max, 0);
                if (i + 1 < nums.length)
                {
                    temp = nums[i + 1];
                    i++;
                }
            }
            else
            {
                
            }
        }
        
        return max;
    }
}
