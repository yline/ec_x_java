package com.test;

/**
 * Given n balloons, indexed from 0 to n-1.
 * 
 * Each balloon is painted with a number on it represented by array nums.
 * 
 * You are asked to burst all the balloons.
 * 
 * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * 
 * Here left and right are adjacent indices of i.
 * 
 * After the burst, the left and right then becomes adjacent.
 * 
 * a,b
 * ==> ab + max(a, b)
 * 
 * a,b,c
 * ==> ab + bc + max(a,b,c)
 * ==> abc + ac + max(a, c)
 * 
 * a,b,c,d
 * ==>
 * 
 * @author YLine
 *
 * 2019年11月5日 下午2:30:03
 */
public class SolutionA
{
    public int maxCoins(int[] nums)
    {
        return -1;
    }
}
