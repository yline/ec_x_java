package com.test.binary;

import com.test.base.Solution;

/**
 * .二分查找法
 * @author YLine
 *
 * 2019年2月22日 下午6:05:54
 */
public class SolutionBintraySearch implements Solution
{
    private static int TYPE = 1;
    
    public static final int TYPE_1 = 1; // 查找值等于给定值的元素[无重复值]
    
    public static final int TYPE_2 = 2; // 查找第一个值等于给定值的元素[有重复值]
    
    public static final int TYPE_3 = 3; // 查找最后一个值等于给定值的元素[有重复值]
    
    public static final int TYPE_4 = 4; // 查找第一个大于等于给定值的元素
    
    public static final int TYPE_5 = 5; // 查找最后一个小于等于给定值的元素
    
    public static void setType(int type)
    {
        TYPE = type;
    }
    
    @Override
    public int bintraySearch(int[] array, int value)
    {
        switch (TYPE)
        {
            case TYPE_1:
                return bintraySearchEqual(array, value);
            case TYPE_2:
                return bintraySearchEqualFirst(array, value);
            case TYPE_3:
                return bintraySearchEqualLast(array, value);
            case TYPE_4:
                return bintraySearchBiggerFirst(array, value);
            case TYPE_5:
                return bintraySearchBiggerLast(array, value);
            default:
                return -1;
        }
    }
    
    /**
     * 查找值等于给定值的元素[无重复值]
     */
    private int bintraySearchEqual(int[] array, int value)
    {
        int left = 0, mid, right = array.length - 1;
        if (value < array[left] || value > array[right])
        {
            return -1;
        }
        
        while (left <= right)
        {
            mid = (left + right) >> 1;
            if (value > array[mid])
            {
                left = mid + 1;
            }
            else if (value < array[mid])
            {
                right = mid - 1;
            }
            else
            {
                return mid;
            }
        }
        
        return -1;
    }
    
    /**
     * 查找第一个值等于给定值的元素[有重复值]
     * @return
     */
    private int bintraySearchEqualFirst(int[] array, int value)
    {
        int left = 0, mid, right = array.length - 1;
        if (value < array[left] || value > array[right])
        {
            return -1;
        }
        
        return -1;
    }
    
    /**
     * 查找最后一个值等于给定值的元素[有重复值]
     */
    private int bintraySearchEqualLast(int[] array, int value)
    {
        return -1;
    }
    
    /**
     * 查找第一个大于等于给定值的元素
     */
    private int bintraySearchBiggerFirst(int[] array, int value)
    {
        return -1;
    }
    
    /**
     * 查找最后一个小于等于给定值的元素
     */
    private int bintraySearchBiggerLast(int[] array, int value)
    {
        return -1;
    }
}
