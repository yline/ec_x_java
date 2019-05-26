package com.test;

import java.util.Arrays;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    @Override
    public boolean judgePoint24(int[] nums)
    {
        if (nums[0] + nums[1] + nums[2] + nums[3] == 24)
        {
            return true;
        }
        
        if (nums[0] * nums[1] * nums[2] * nums[3] == 24)
        {
            return true;
        }
        
        Arrays.sort(nums);
        switch (nums[0])
        {
            case 1:
                if (nums[1] + nums[2] + nums[3] == 24)
                {
                    return true;
                }
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            default: // 最小值，大于等于5全部失败
                return false;
        }
        return false;
    }
    
    public int heightChecker(int[] heights)
    {
        int[] temp = new int[heights.length];
        for (int i = 0; i < temp.length; i++)
        {
            temp[i] = heights[i];
        }
        
        Arrays.sort(temp);
        int result = 0;
        for (int i = 0; i < temp.length; i++)
        {
            if (temp[i] != heights[i])
            {
                result++;
            }
        }
        return result;
    }
    
    public int maxSatisfied(int[] customers, int[] grumpy, int X)
    {
        int sum = 0, max = 0;
        for (int i = 0; i < grumpy.length; i++)
        {
            if (grumpy[i] == 0) // 满意
            {
                sum += customers[i];
            }
            else
            {
                max = Math.max(max, sumOf(customers, grumpy, X, i));
            }
        }
        
        return sum + max;
    }
    
    private int sumOf(int[] customers, int[] grumpy, int X, int start)
    {
        int result = 0;
        for (int i = start; i < start + X; i++)
        {
            // 数组越界处理
            if (i == customers.length)
            {
                return result;
            }
            
            if (grumpy[i] == 1)
            {
                result += customers[i];
            }
        }
        
        return result;
    }
}
