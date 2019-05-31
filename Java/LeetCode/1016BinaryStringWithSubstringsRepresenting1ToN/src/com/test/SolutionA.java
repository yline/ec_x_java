package com.test;

import java.util.BitSet;

/**
 * Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N,
 * 给一个字符串，有0和1组成
 * 
 * return true if and only if for every integer X from 1 to N, 
 * the binary representation of X is a substring of S.
 * 
 * 当字符串的子字符串，可以表示1-N的所有数时，返回true
 * 
 * 解决方案：从后往前遍历，如果某个值未赋值，则赋值，最后校验是否全部为true即可
 * 
 * @author YLine
 *
 * 2019年5月31日 上午7:59:41
 */
public class SolutionA
{
    public boolean queryString(String S, int N)
    {
        Result result = new Result(N);
        
        int value = 0, indexValue = 0;
        for (int i = S.length() - 1; i >= 0; i--)
        {
            // 计算总值，既然是位移，就算了
            if ('0' == S.charAt(i))
            {
                
            }
            else
            {
                
            }
        }
        
        return result.isTrue();
    }
    
    public static class Result
    {
        private int sSize; // 当前数
        
        private int sCount; // 总数
        
        private BitSet sBitSet; // 缓存
        
        public Result(int count)
        {
            sCount = count;
            sSize = 0;
            sBitSet = new BitSet(count);
        }
        
        public void addValue(int value)
        {
            if (!sBitSet.get(value - 1)) // 如果未添加过，则添加
            {
                sSize++;
                sBitSet.set(value - 1, true);
            }
        }
        
        public boolean isTrue()
        {
            return sSize == sCount;
        }
    }
}
