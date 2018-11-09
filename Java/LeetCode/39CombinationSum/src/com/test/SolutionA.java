package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        int rightMax = getMaxIndex(candidates, target);
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        
        int tempResult = 0;
        
        int left = 0, index = 0;
        while (left < rightMax)
        {
            if (index > rightMax) // 超越了临界值
            {
                left++;
                index = left;
            }
            
            if (tempResult + candidates[index] > target)
            {
                // 复原
                tempResult -= tempList.get(tempList.size() - 1);
                tempList.remove(tempList.size() - 1);
                
                index++;
            }
            else if (tempResult + candidates[index] == target)
            {
                // 添加 满足条件的内容
                List<Integer> dataList = new ArrayList<>(tempList);
                dataList.add(candidates[index]);
                result.add(tempList);
                
                // 复原
                if (!tempList.isEmpty())
                {
                    tempResult -= tempList.get(tempList.size() - 1);
                    tempList.remove(tempList.size() - 1);
                }
                
                index++;
            }
            else
            {
                tempResult += candidates[index];
                tempList.add(candidates[index]); // 添加到临时列表
            }
        }
        
        return result;
    }
    
    /**
     * 获取 数组中 比较目标值，最大的值
     * 防止超越最大值，超越目标值，导致的没必要的多次循环
     * 
     * @param candidates 数组
     * @param target 目标值
     * @return 最右侧的值
     */
    private int getMaxIndex(int[] candidates, int target)
    {
        for (int i = candidates.length - 1; i >= 0; i--)
        {
            if (candidates[i] <= target)
            {
                return i;
            }
        }
        return 0;
    }
    
    public void bay()
    {
        
    }
    
    /**
     * 计算出结果
     * @param result 最终返回的数据
     * @param candidates 组合的原始值
     * @param start 开始遍历的位置
     * @param tempTarget 当前的总和
     * @param target 目标值
     */
    /*
    public void combine(int[] candidates, int start, int target)
    {
        // 上次总值，新计算出的总值
        int lastTotal = 0, newTotal = 0;
        
        List<Integer> singleList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < candidates.length;)
        {
            newTotal = lastTotal + candidates[i];
            if (newTotal > target)
            {
                lastTotal -= singleList.get(singleList.size() - 1); // 更新总和
                singleList.remove(singleList.size() - 1); // 移除最后一个
                
                i++; // 移动位置
            }
            else if (newTotal < target)
            {
                singleList.add(candidates[i]);
                lastTotal = newTotal;
            }
            else
            {
                result.add(singleList); // 符合要求
                
                lastTotal -= singleList.get(singleList.size() - 1);
            }
        }
    }*/
}
