package com.test;

import java.util.HashSet;

/**
 * Given an array of numbers nums,
 * in which exactly two elements appear only once
 * and all the other elements appear exactly twice.
 * 
 * Find the two elements that appear only once.
 * 
 * @author YLine
 *
 * 2019年11月20日 下午5:05:39
 */
public class SolutionA
{
    public int[] singleNumber(int[] nums)
    {
        // 遍历，排除
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (hashSet.contains(nums[i]))
            {
                hashSet.remove(nums[i]);
            }
            else
            {
                hashSet.add(nums[i]);
            }
        }
        
        // 赋值
        int[] result = new int[2];
        
        int index = 0;
        for (int value : hashSet)
        {
            result[index] = value;
            index++;
            
            // 终结，防止意外
            if (index == 2)
            {
                break;
            }
        }
        
        return result;
    }
}
