package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution
{
    /** Time Limit Exceeded(n^4);
     * 采用同时移动3.4的方式,降低一个维度的复杂度 */
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        
        int length = nums.length;
        if (length < 4)
        {
            return result;
        }
        
        Arrays.sort(nums);
        
        int one, two, three, four;
        
        one = 0;
        while (one < length - 3)
        {
            two = one + 1;
            while (two < length - 2)
            {
                three = two + 1;
                while (three < length - 1)
                {
                    four = three + 1;
                    while (four < length)
                    {
                        // 符合条件,就添加到内容
                        if (nums[one] + nums[two] + nums[three] + nums[four] == target)
                        {
                            result.add(getList(nums[one], nums[two], nums[three], nums[four]));
                        }
                        
                        four++;
                        while (four < length && nums[four] == nums[four - 1])
                        {
                            four++;
                        }
                    }
                    
                    // 移动 three
                    three++;
                    while (three < length - 1 && nums[three] == nums[three - 1])
                    {
                        three++;
                    }
                }
                
                // 移动 two
                two++;
                while (two < length - 2 && nums[two] == nums[two - 1])
                {
                    two++;
                }
            }
            
            // 移动 one
            one++;
            while (one < length - 3 && nums[one] == nums[one - 1])
            {
                one++;
            }
        }
        
        return result;
    }
    
    public List<Integer> getList(int one, int two, int three, int four)
    {
        List<Integer> result = new ArrayList<>();
        result.add(one);
        result.add(two);
        result.add(three);
        result.add(four);
        
        return result;
    }
    
    /**
     * n^3
     * <pre>
     * 原题
     * Given an array S of n integers, are there elements a, b, c, and d in S
     * such that a + b + c + d = target? Find all unique quadruplets in the array
     * which gives the sum of target.
     * Note:
     * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
     * The solution set must not contain duplicate quadruplets.
     *
     * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
     *
     * A solution set is:
     * (-1,  0, 0, 1)
     * (-2, -1, 1, 2)
     * (-2,  0, 0, 2)
     *
     * 题目大意
     * 给定一个整数数组，找出a + b + c + d = target的唯一解。
     *
     * 解题思路
     * 先确定a和d的两个数，对于a和d两个数，不能同时重复使用。然后再确定b和c，同样这两个数也不能
     * 同时重复使用。找出所有满足条件的解，同时可以保证解不重复。
     * </pre>
     *
     * @param num
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum2(int[] num, int target)
    {
        List<List<Integer>> result = new LinkedList<>();
        if (num == null || num.length < 4)
        {
            return result;
        }
        
        Arrays.sort(num); // 对数组进行排序
        
        for (int i = 0; i < num.length - 3; i++)
        { // 第一个加数
            if (i > 0 && num[i] == num[i - 1])
            { // 第一个加数使用不重复
                continue;
            }
            
            for (int j = num.length - 1; j > i + 2; j--)
            { // 第四个加数
                if (j < num.length - 1 && num[j] == num[j + 1])
                { // 第四个加数使用不重复
                    continue;
                }
                
                int start = i + 1; // 第二个加数
                int end = j - 1; // 第三个加数
                int n = target - num[i] - num[j];
                
                while (start < end)
                {
                    if (num[start] + num[end] == n)
                    {
                        List<Integer> four = new ArrayList<>(4);
                        four.add(num[i]);
                        four.add(num[start]);
                        four.add(num[end]);
                        four.add(num[j]);
                        
                        result.add(four);
                        
                        do
                        {
                            start++;
                        } while (start < end && num[start] == num[start - 1]); // 保证再次使用第二个数不重复
                        
                        do
                        {
                            end--;
                        } while (start < end && num[end] == num[end + 1]); // 保证再次使用第三个数不重复
                    }
                    else if (num[start] + num[end] < n)
                    {
                        do
                        {
                            start++;
                        } while (start < end && num[start] == num[start - 1]); // 保证再次使用第二个数不重复
                    }
                    else
                    {
                        do
                        {
                            end--;
                        } while (start < end && num[end] == num[end + 1]); // 保证再次使用第三个数不重复
                    }
                }
            }
        }
        return result;
    }
}