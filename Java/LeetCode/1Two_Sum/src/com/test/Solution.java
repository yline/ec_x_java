package com.test;

/**
 * 假设有唯一解(冒泡排序法)
 * @author YLine
 *
 * 2016年12月15日 下午6:48:27
 */
public class Solution
{
    public int[] twoSum(int[] nums, int target)
    {
        int i = 0, j = i + 1;
        
        // 遍历获取结果
        while (i != (nums.length - 1))
        {
            // System.out.println("i = " + i + ", j = " + j);
            
            if (nums[i] + nums[j] != target)
            {
                if (j == (nums.length - 1))
                {
                    i += 1;
                    j = i + 1;
                }
                else
                {
                    j += 1;
                }
            }
            else
            {
                return new int[] {i, j};
            }
        }
        
        return new int[] {0, 0};
    }
}
