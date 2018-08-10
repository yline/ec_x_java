package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.base.Solution;

public class SolutionC implements Solution
{
    
    /**
     * 这个移动的思路是错的~ ,因为 左边大,不见得一定移动左边
     * 但如果,固定了一个之后,左边大就一定移动左边
     * @param nums
     * @return
     */
    @Override
    public List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        
        int left = 0, right = nums.length - 1;
        int tempOpposite;
        List<List<Integer>> result = new ArrayList<>();
        
        // 要求长度大于3
        while (right - left > 1)
        {
            // 如果最小数大于0,或者最大数小于0,则结束 While循环
            if (nums[left] > 0 || nums[right] < 0)
            {
                break;
            }
            
            tempOpposite = 0 - (nums[left] + nums[right]);
            for (int i = left + 1; i < right; i++)
            {
                // 是否有数据符合条件
                if (tempOpposite == nums[i])
                {
                    result.add(getList(nums[left], nums[i], nums[right]));
                    // break; // 退出 for循环
                }
            }
            
            // 如果等于0,则需要建设性的 两边各自移动一次
            if (tempOpposite == 0)
            {
                int resumeLeft = left + 1;
                int resumeRight = right - 1;
                
                // 如果是相同的数,则接着移动
                while (nums[resumeLeft] == nums[left])
                {
                    resumeLeft += 1;
                    // 如果已经小于边界值,退出函数
                    if (right - resumeLeft < 1)
                    {
                        return result;
                    }
                }
                
                while (nums[resumeRight] == nums[right])
                {
                    resumeRight -= 1;
                    if (resumeRight - left < 1)
                    {
                        return result;
                    }
                }
                
                int resumeTempOpposite = 0 - (nums[resumeLeft] + nums[right]);
                for (int i = resumeLeft + 1; i < right; i++)
                {
                    // 是否有数据符合条件
                    if (resumeTempOpposite == nums[i])
                    {
                        result.add(getList(nums[resumeLeft], nums[i], nums[right]));
                        break; // 退出 for循环
                    }
                }
                
                resumeTempOpposite = 0 - (nums[left] + nums[resumeRight]);
                for (int i = left + 1; i < resumeRight; i++)
                {
                    // 是否有数据符合条件
                    if (resumeTempOpposite == nums[i])
                    {
                        result.add(getList(nums[left], nums[i], nums[resumeRight]));
                        break; // 退出 for循环
                    }
                }
                
                left = resumeLeft;
                right = resumeRight;
            }
            else
            {
                if (Math.abs(nums[left]) > Math.abs(nums[right]))
                {
                    int resumeLeft = left + 1;
                    while (nums[resumeLeft] == nums[left])
                    {
                        resumeLeft += 1;
                        // 如果已经小于边界值,退出函数
                        if (right - resumeLeft < 1)
                        {
                            return result;
                        }
                    }
                    
                    left = resumeLeft;
                }
                else
                {
                    int resumeRight = right - 1;
                    while (nums[resumeRight] == nums[right])
                    {
                        resumeRight -= 1;
                        if (resumeRight - left < 1)
                        {
                            return result;
                        }
                    }
                    right = resumeRight;
                }
            }
        }
        
        System.out.println(result.toString());
        return result;
    }
    
    private List<Integer> getList(int one, int two, int three)
    {
        List<Integer> tempResult = new ArrayList<>();
        tempResult.add(one);
        tempResult.add(two);
        tempResult.add(three);
        return tempResult;
    }
}
