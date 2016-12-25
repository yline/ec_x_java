package com.test;

/**
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * 
 * Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.
 * 
 * @author YLine
 *
 * 2016年12月25日 下午9:04:21
 */
public class Solution
{
    /**
     * 额外条件:如果两边向中间移动
     * 1,左边移动,比先前地点低的,不需要移动
     * 2,右边移动,比先前地点低的,不需要移动
     * 3,左边和右边,移动较高的一边完全对于改变水容量完全没有意义
     * @param height
     * @return
     */
    public int maxArea(int[] height)
    {
        if (null == height || height.length < 2)
        {
            return 0;
        }
        
        int maxLeft = 0;
        int maxRight = height.length - 1;
        int maxResult = 0;
        
        while (maxLeft < maxRight)
        {
            maxResult = Math.max(maxResult, (maxRight - maxLeft) * Math.min(height[maxLeft], height[maxRight]));
            
            if (height[maxLeft] < height[maxRight])
            {
                // 移动左边
                int i = maxLeft + 1;
                for (; i < height.length; i++)
                {
                    if (height[maxLeft] < height[i])
                    {
                        maxLeft = i;
                        break;
                    }
                }
                
                // 左边低,而且左边不能移动了
                if (i == height.length)
                {
                    return maxResult;
                }
            }
            else
            {
                // 移动右边
                int i = maxRight - 1;
                for (; i >= 0; i--)
                {
                    if (height[maxRight] < height[i])
                    {
                        maxRight = i;
                        break;
                    }
                }
                
                // 右边低,而且右边不能移动了
                if (i == -1)
                {
                    return maxResult;
                }
            }
        }
        
        return maxResult;
    }
    
    /**
     * 测试通过,但还是不够贪心;  超出时间限制
     * @param height
     * @return
     */
    public int maxArea2(int[] height)
    {
        int maxLeft = 0;
        int maxRight = height.length - 1;
        int tempMax = 0;
        int maxResult = caculateWater(height, maxLeft, maxRight);
        
        for (int i = 0; i < height.length;)
        {
            for (int j = height.length - 1; j > 0;)
            {
                tempMax = caculateWater(height, i, j);
                if (maxResult < tempMax)
                {
                    maxLeft = i;
                    maxRight = j;
                    maxResult = tempMax;
                }
                
                j = moveRight(height, j);
            }
            i = moveLeft(height, i);
        }
        
        System.out.println("maxLeft = " + maxLeft + ",maxRight = " + maxRight);
        return maxResult;
    }
    
    private int caculateWater(int[] array, int i, int j)
    {
        return Math.min(array[i], array[j]) * Math.abs(i - j);
    }
    
    /**
     * 从左往右移动，如果遇到大的,则移动；小的，则跳过
     * @param array
     * @param left
     * @return
     */
    private int moveLeft(int[] array, int left)
    {
        for (int i = left; i < array.length; i++)
        {
            if (array[left] < array[i])
            {
                return i;
            }
        }
        return array.length;
    }
    
    /**
     * 从右往左移动,如果遇到 大的,则移动；小的,则跳过
     * @param array 数列
     * @param right 此时的值
     * @return 下一个值
     */
    private int moveRight(int[] array, int right)
    {
        for (int i = right; i > 0; i--)
        {
            if (array[right] < array[i])
            {
                return i;
            }
        }
        return -1;
    }
}
