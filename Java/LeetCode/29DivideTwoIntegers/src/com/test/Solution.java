package com.test;

/**
 * 这道题,太心力憔悴了
 * @author YLine
 *
 * 2017年2月4日 下午11:53:36
 */
public class Solution
{
    /**
     * Divide two integers without using multiplication, division and mod operator.
     * 
     * If it is overflow, return MAX_INT.
     * 
     * @param lDividend
     * @param lDivisor
     * @return
     */
    public int divide(int dividend, int divisor)
    {
        boolean positive;
        
        long lDividend = 0, lDivisor = 0;
        
        // 判断符号
        if (dividend > 0)
        {
            lDividend = Integer.toUnsignedLong(dividend);
            if (divisor > 0)
            {
                positive = true;
                lDivisor = Integer.toUnsignedLong(divisor);
            }
            else
            {
                positive = false;
                lDivisor = Integer.toUnsignedLong(-divisor);
            }
        }
        else
        {
            lDividend = Integer.toUnsignedLong(-dividend);
            if (divisor > 0)
            {
                positive = false;
                lDivisor = Integer.toUnsignedLong(divisor);
            }
            else
            {
                positive = true;
                lDivisor = Integer.toUnsignedLong(-divisor);
            }
        }
        
        // 判断0的条件
        if (lDivisor == 0)
        {
            return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        // 正式计算
        
        // 1,准备数据
        long[] levelBase = new long[32];
        long[] levelNumber = new long[32];
        
        int i = 0;
        long tempBase = 1;
        long tempNumber = lDivisor;
        
        do
        {
            levelBase[i] = tempBase;
            levelNumber[i] = tempNumber;
            
            tempBase += tempBase;
            tempNumber += tempNumber;
            
            i++;
            
        } while (lDividend >= tempNumber);
        
        System.out.println("i = " + i);
        
        // 2,准备结果数组
        long temp = 0, total = 0;
        int count = i; // int[]的 有数长度
        boolean[] levelAble = new boolean[32];
        
        while (temp < lDividend && i > 0)
        {
            total = temp + levelNumber[i - 1];
            if (total < lDividend)
            {
                temp = total;
                levelAble[i - 1] = true;
                i--;
            }
            else if (total == lDividend)
            {
                levelAble[i - 1] = true;
                break;
            }
            else
            {
                i--;
            }
        }
        
        // 计算最终结果
        long result = 0;
        for (int j = 0; j < count; j++)
        {
            if (levelAble[j] == true)
            {
                result += levelBase[j];
            }
        }
        
        // 输出结果,需要先排除边界情况
        if (result > Integer.MAX_VALUE)
        {
            return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        else
        {
            return positive ? (int)result : -(int)result;
        }
    }
    
    /**
     * <pre>
     * Divide two integers without using multiplication, division and mod operator.
     * If it is overflow, return MAX_INT.
     *
     * 题目大意：
     * 不使用除法，乘法和取余，求两个整数的相除的结果，如果有溢出就返回最大的整数
     *
     * 解题思路：
     * 任何一个整数可以表示成以2的幂为底的一组基的线性组合，
     * 即num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n。
     * 基于以上这个公式以及左移一位相当于乘以2，我们先让除
     * 数左移直到大于被除数之前得到一个最大的基。然后接下来我们
     * 每次尝试减去这个基，如果可以则结果增加加2^k,然后基继续右
     * 移迭代，直到基为0为止。因为这个方法的迭代次数是按2的幂知
     * 道超过结果，所以时间复杂度为O(log(n))。
     *
     * </pre>
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide2(int dividend, int divisor)
    {
        // 相除时溢出处理
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)
        {
            return Integer.MAX_VALUE;
        }
        
        // 求符号位
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        
        // 求绝对值，为防止溢出使用long
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        
        // 记录结果
        int result = 0;
        
        // 被除数大于除数
        while (dvd >= dvs)
        {
            // 记录除数
            long tmp = dvs;
            // 记录商的大小
            long mul = 1;
            
            while (dvd >= (tmp << 1))
            {
                tmp <<= 1;
                mul <<= 1;
            }
            
            // 减去最接近dvd的dvs的指数倍的值（值为tmp）
            dvd -= tmp;
            
            // 修正结果
            result += mul;
        }
        
        return result * sign;
    }
}
