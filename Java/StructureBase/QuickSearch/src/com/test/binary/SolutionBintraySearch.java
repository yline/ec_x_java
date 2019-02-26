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
    
    public static final int TYPE_EQUAL = 1; // 查找值等于给定值的元素[无重复值]
    
    public static final int TYPE_EQUAL_FIRST = 2; // 查找第一个值等于给定值的元素[有重复值]
    
    public static final int TYPE_EQUAL_LAST = 3; // 查找最后一个值等于给定值的元素[有重复值]
    
    public static final int TYPE_BIGGER_FIRST = 4; // 查找第一个大于等于给定值的元素
    
    public static final int TYPE_SMALLER_LAST = 5; // 查找最后一个小于等于给定值的元素
    
    public static void setType(int type)
    {
        TYPE = type;
    }
    
    @Override
    public int bintraySearch(int[] array, int value)
    {
        switch (TYPE)
        {
            case TYPE_EQUAL_LAST:
                return bintraySearchEqualLast(array, value);
            case TYPE_BIGGER_FIRST:
                return bintraySearchBiggerFirst(array, value);
            case TYPE_SMALLER_LAST:
                return bintraySearchSmallerLast(array, value);
            default:
                return -1;
        }
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
    private int bintraySearchSmallerLast(int[] array, int value)
    {
        return -1;
    }
}
