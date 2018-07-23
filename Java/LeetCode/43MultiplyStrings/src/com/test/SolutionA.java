package com.test;

import com.test.base.Solution;

/**
 * 解题思路
 * 
 * 时间复杂度
 * 
 * @author YLine
 *
 * 2018年7月23日 下午4:25:13
 */
public class SolutionA implements Solution
{
    
    @Override
    public String multiply(String num1, String num2)
    {
        if (null == num1 || "".equals(num1) || "0".equals(num2))
        {
            return "0";
        }
        
        if (null == num2 || "".equals(num2) || "0".equals(num2))
        {
            return "0";
        }
        
        int length1 = num1.length(), length2 = num2.length();
        
        // 假设最大长度，计算每一个节点的大小【不做求余操作】
        int[] result = new int[length1 + length2];
        int j = 0;
        for (int i = 0; i < result.length; i++)
        {
            // 重置结果
            j = 0;
            result[i] = 0;
            // 累加
            while (j <= i && j < length1 && (i - j) < length2)
            {
                result[i] = (num1.charAt(j) - '0') * (num2.charAt(i - j) - '0');
                j++;
            }
        }
        
        // 进行求余操作，由于最多110个字符，因此最大值为110*81 = 8910，最多3位数
        int one = 0, two = 0, three = 0, four = 0;
        for (int i = 0; i < result.length; i++)
        {
            one = result[i] % 10;
            two = result[i] % 100 / 10;
            three = result[i] % 1000 / 100;
            four = result[i] / 1000;
        }
        
        // 重整和删减
        
        return null;
    }
    
}
