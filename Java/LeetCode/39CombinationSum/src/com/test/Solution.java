package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        
        return null;
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
    }
}
