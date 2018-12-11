package com.test;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    
    @Override
    public int maxProfit(int[] prices)
    {
        if (null == prices || prices.length < 2)
        {
            return 0;
        }
        
        int profit = 0;
        
        // 第一次，遍历获取的结果
        int firstMinIndex = -1, firstMaxIndex = -1;
        
        int minValue = prices[0], minIndex = 0;
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] > minValue)
            {
                if (profit < prices[i] - minValue)
                {
                    profit = prices[i] - minValue;
                    firstMinIndex = minIndex;
                    firstMaxIndex = i;
                }
            }
            else
            {
                minValue = prices[i];
                minIndex = i;
            }
        }
        
        // 第二次遍历
        if (0 == profit)
        {
            return 0;
        }
        
        // 小于4，则返回第一次的值
        if (prices.length < 4)
        {
            return profit;
        }
        
        // 取最小值
        for (int i = 0; i < 4; i++)
        {
            if (i != firstMinIndex && i != firstMaxIndex)
            {
                minValue = prices[i];
                minIndex = i;
            }
        }
        
        int secondProfit = 0;
        for (int i = minIndex; i < prices.length; i++)
        {
            if (i != firstMinIndex && i != firstMaxIndex)
            {
                if (prices[i] > minValue)
                {
                    secondProfit = Math.max(secondProfit, prices[i] - minValue);
                }
                else
                {
                    minValue = prices[i];
                }
            }
        }
        
        return profit + secondProfit;
        
    }
}
