package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.base.Solution;

/**
 * {1,2,2,2,5} --> 5
 * 
 * 公式：f(n) = 1*f(n-1) + 0*f(n - 1)
 * 函数f(n)表示，从左到右，n个数值的组合
 * 
 * @author YLine
 *
 * 2018年11月13日 下午8:05:34
 */
public class SolutionA implements Solution
{
    
    @Override
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }
    
    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> path, int index)
    {
        if (target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        if (target < 0 || index >= candidates.length)
        {
            return;
        }
        
        // 1*f(n-1)
        path.add(candidates[index]);
        dfs(candidates, target - candidates[index], result, path, index + 1);
        path.remove(path.size() - 1);
        
        // 0*f(n-1)
        dfs(candidates, target, result, path, index + 1);
    }
}
