package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero
 * @author YLine
 *
 * 2017年1月12日 下午9:01:36
 */
public class Solution
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        
        return null;
    }
    
    public List<Integer> getList(int one, int two, int three)
    {
        List<Integer> tempResult = new ArrayList<>();
        tempResult.add(one);
        tempResult.add(two);
        tempResult.add(three);
        return tempResult;
    }
}
