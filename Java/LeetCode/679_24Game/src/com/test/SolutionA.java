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
}
