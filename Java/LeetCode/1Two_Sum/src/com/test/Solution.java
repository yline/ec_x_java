package com.test;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * 
 * Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

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
