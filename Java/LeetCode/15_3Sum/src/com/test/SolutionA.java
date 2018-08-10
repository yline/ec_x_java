package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
    /**
     * 暴力 遍历，复杂度高了
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        
        int first = 0, tempFirst;
        int tempOpposite;
        int length = nums.length;
        
        Arrays.sort(nums);
        
        if (length < 3)
        {
            return result;
        }
        
        while (first < length - 2)
        {
            // 如果最小的数,都大于0之后,结束循环
            if (nums[first] > 0)
            {
                break;
            }
            
            tempOpposite = 0 - nums[first];
            
            for (int i = first + 1; i < length; i++)
            {
                for (int j = i + 1; j < length; j++)
                {
                    if (nums[i] + nums[j] == tempOpposite)
                    {
                        setResult(result, nums[first], nums[i], nums[j]);
                        break;
                    }
                    else if (nums[i] + nums[j] > tempOpposite)
                    {
                        break;
                    }
                }
            }
            
            tempFirst = first + 1;
            for (int i = tempFirst; i < length; i++)
            {
                if (nums[first] == nums[tempFirst])
                {
                    tempFirst++;
                }
            }
            first = tempFirst;
        }
        
        return result;
    }
    
    private void setResult(List<List<Integer>> result, int one, int two, int three)
    {
        for (List<Integer> list : result)
        {
            if (list.get(0) == one && list.get(1) == two)
            {
                return;
            }
        }
        
        List<Integer> tempResult = new ArrayList<>();
        tempResult.add(one);
        tempResult.add(two);
        tempResult.add(three);
        
        result.add(tempResult);
    }
    
    /**
     * 这个移动的思路是错的~ ,因为 左边大,不见得一定移动左边
     * 但如果,固定了一个之后,左边大就一定移动左边
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_11(int[] nums)
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
    
    public List<Integer> getList(int one, int two, int three)
    {
        List<Integer> tempResult = new ArrayList<>();
        tempResult.add(one);
        tempResult.add(two);
        tempResult.add(three);
        return tempResult;
    }
    
    public List<List<Integer>> threeSum2(int[] nums)
    {
        List<List<Integer>> result = new LinkedList<>();
        
        if (nums != null && nums.length > 2)
        {
            // 先对数组进行排序
            Arrays.sort(nums);
            // i表示假设取第i个数作为结果
            for (int i = 0; i < nums.length - 2;)
            {
                // 第二个数可能的起始位置
                int j = i + 1;
                // 第三个数可能是结束位置
                int k = nums.length - 1;
                
                while (j < k)
                {
                    // 如果找到满足条件的解
                    if (nums[j] + nums[k] == -nums[i])
                    {
                        // 将结果添加到结果含集中
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                        
                        // 移动到下一个位置，找下一组解
                        k--;
                        j++;
                        
                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[j] == nums[j - 1])
                        {
                            j++;
                        }
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[k] == nums[k + 1])
                        {
                            k--;
                        }
                    }
                    // 和大于0
                    else if (nums[j] + nums[k] > -nums[i])
                    {
                        k--;
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[k] == nums[k + 1])
                        {
                            k--;
                        }
                    }
                    // 和小于0
                    else
                    {
                        j++;
                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[j] == nums[j - 1])
                        {
                            j++;
                        }
                    }
                }
                
                // 指向下一个要处理的数
                i++;
                // 从左向右找第一个与之前处理的数不同的数的下标
                while (i < nums.length - 2 && nums[i] == nums[i - 1])
                {
                    i++;
                }
            }
        }
        
        return result;
    }
}
