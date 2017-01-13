package com.test;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * 
 * Such as:
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author YLine
 *
 * 2017年1月12日 下午9:01:36
 */
public class Solution
{
    public int threeSumClosest(int[] nums, int target)
    {
        int result = Integer.MAX_VALUE, minDiff = Integer.MAX_VALUE;
        
        // 传入数据 违规
        if (null == nums || nums.length < 3)
        {
            return result;
        }
        
        Arrays.sort(nums);
        
        int length = nums.length;
        
        int one = 0, two, three, tempTraget;
        while (length - one > 2)
        {
            two = one + 1;
            three = length - 1;
            
            while (two < three)
            {
                tempTraget = nums[one] + nums[two] + nums[three];
                if (tempTraget == target)
                {
                    return target;
                }
                else if (tempTraget < target)
                {
                    if (minDiff > target - tempTraget)
                    {
                        minDiff = target - tempTraget;
                        result = tempTraget;
                    }
                    
                    two++;
                }
                else
                {
                    if (minDiff > tempTraget - target)
                    {
                        minDiff = tempTraget - target;
                        result = tempTraget;
                    }
                    
                    three--;
                }
            }
            
            one++;
            while (length > one && nums[one] == nums[one - 1])
            {
                one++;
            }
        }
        
        return result;
    }
}
