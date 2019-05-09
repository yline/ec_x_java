package com.test;

import com.test.base.Solution;

/**
 * @author YLine
 *
 * 2019年5月9日 上午8:25:07
 */
public class SolutionA implements Solution
{
    @Override
    public double soupServings(int N)
    {
        Result result = new Result();
        dfs(N, N, result);
        return (result.a + result.ab / 2.0) / result.total;
    }
    
    private void dfs(int valueA, int valueB, Result result)
    {
        // 第一种方案
        if (valueA > 100)
        {
            if (valueB > 0)
            {
                dfs(valueA - 100, valueB, result);
            }
        }
        else
        {
            if (valueB > 0)
            {
                result.a++;
            }
            else
            {
                result.ab++;
            }
        }
        
        // 第二种方案
        if (valueA > 75)
        {
            if (valueB > 25)
            {
                dfs(valueA - 75, valueB - 25, result);
            }
        }
        else
        {
            if (valueB > 25)
            {
                result.a++;
            }
            else
            {
                result.ab++;
            }
        }
        
        // 第三种方案
        if (valueA > 50)
        {
            if (valueB > 50)
            {
                dfs(valueA - 50, valueB - 50, result);
            }
        }
        else
        {
            if (valueB > 50)
            {
                result.a++;
            }
            else
            {
                result.ab++;
            }
        }
        
        // 第四种方案
        if (valueA > 25)
        {
            if (valueB > 75)
            {
                dfs(valueA - 25, valueB - 75, result);
            }
        }
        else
        {
            if (valueB > 75)
            {
                result.a++;
            }
            else
            {
                result.ab++;
            }
        }
        result.total += 4;
    }
    
    public static class Result
    {
        private int a; // a出现的情况个数
        
        private int ab; // ab出现的情况的个数
        
        private int total; // 总个数
        
        public Result()
        {
            this.a = 0;
            this.ab = 0;
            this.total = 0;
        }
    }
}
