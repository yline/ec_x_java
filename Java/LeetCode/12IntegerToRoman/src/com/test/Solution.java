package com.test;

import java.util.Arrays;

public class Solution
{
    /**
     * 如下符号：Ｉ、Ｖ、Ｘ、Ｌ、Ｃ、Ｄ和Ｍ，分别表示１、５、１０、５０、１００、５００和１０００；
     * @param num
     * @return
     */
    public String intToRoman(int num)
    {
        if (num <= 0 || num > 3999)
        {
            return null;
        }
        
        StringBuffer result = new StringBuffer();
        
        int[] array = getIntArray(num);
        
        System.out.println(Arrays.toString(array));
        
        // 千位
        for (int i = 0; i < array[0]; i++)
        {
            result.append("M");
        }
        
        // 百位
        if (9 == array[1])
        {
            result.append("CM");
        }
        else if (array[1] >= 5)
        {
            result.append("D");
            for (int i = 0; i < array[1] - 5; i++)
            {
                result.append("C");
            }
        }
        else if (4 == array[1])
        {
            result.append("CD");
        }
        else
        {
            for (int i = 0; i < array[1]; i++)
            {
                result.append("C");
            }
        }
        
        // 十位
        if (9 == array[2])
        {
            result.append("XC");
        }
        else if (array[2] >= 5)
        {
            result.append("L");
            for (int i = 0; i < array[2] - 5; i++)
            {
                result.append("X");
            }
        }
        else if (4 == array[2])
        {
            result.append("XL");
        }
        else
        {
            for (int i = 0; i < array[2]; i++)
            {
                result.append("X");
            }
        }
        
        // 个位
        if (9 == array[3])
        {
            result.append("IX");
        }
        else if (array[3] >= 5)
        {
            result.append("V");
            for (int i = 0; i < array[3] - 5; i++)
            {
                result.append("I");
            }
        }
        else if (4 == array[3])
        {
            result.append("IV");
        }
        else
        {
            for (int i = 0; i < array[3]; i++)
            {
                result.append("I");
            }
        }
        
        return result.toString();
    }
    
    private int[] getIntArray(int num)
    {
        int[] result = new int[4];
        
        result[0] = num / 1000; // M D
        num %= 1000;
        
        result[1] = num / 100; // C L
        num %= 100;
        
        result[2] = num / 10; // X V
        num %= 10;
        
        result[3] = num % 10; // V I
        
        return result;
    }
    
    /**
     * <pre>
     * Given an integer, convert it to a roman numeral.
     *
     * Input is guaranteed to be within the range from 1 to 3999.
     *
     * 罗马数字的表示：
     * 个位数举例
     * (I, 1)  (II, 2)  (III, 3)  (IV, 4)  (V, 5)  (VI, 6)  (VII, 7)  (VIII, 8)  (IX, 9)
     *
     * 十位数举例
     * (X, 10)  (XI, 11)  (XII, 12)  (XIII, 13)  (XIV, 14)  (XV, 15)  (XVI, 16)
     * (XVII, 17)  (XVIII, 18)  (XIX, 19)  (XX, 20)  (XXI, 21)  (XXII, 22)
     * (XXIX, 29)  (XXX, 30)  (XXXIV, 34)  (XXXV, 35)  (XXXIX, 39)  (XL, 40)
     * (L, 50)  (LI, 51)  (LV, 55)  (LX, 60)  (LXV, 65)  (LXXX, 80)  (XC, 90)
     * (XCIII, 93)  (XCV, 95)  (XCVIII, 98)  (XCIX, 99)
     *
     * 百位数举例
     * (C, 100)  (CC, 200)  (CCC, 300)  (CD, 400)  (D, 500)  (DC, 600)  (DCC, 700)
     * (DCCC, 800)  (CM, 900)  (CMXCIX, 999)
     *
     * 千位数举例
     * (M, 1000)  (MC, 1100)  (MCD, 1400)  (MD, 1500)  (MDC, 1600)  (MDCLXVI, 1666)
     * (MDCCCLXXXVIII, 1888)  (MDCCCXCIX, 1899)  (MCM, 1900)  (MCMLXXVI, 1976)
     * (MCMLXXXIV, 1984)  (MCMXC, 1990)  (MM, 2000)  (MMMCMXCIX, 3999)
     *
     * 题目大意：
     * 输入一个数字，将它转成一个罗马数字，输入的数字在[1, 3999]之间
     *
     * </pre>
     *
     * @param num
     * @return
     */
    public String intToRoman2(int num)
    {
        
        String[][] base = new String[][] {{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, // 个位的表示
            {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, // 十位的表示
            {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, // 百倍的表示
            {"M", "MM", "MMM", "", "", "", "", "", ""}}; // 千位的表示
        
        String result = "";
        
        // 每除一次就示处理后一个数位（从小到大）
        // i记录当前处理的是第几个数位
        for (int i = 0; num != 0; num /= 10, i++)
        {
            // 如果不为0，说明这个数位上有值，要进行相加操作
            if (num % 10 != 0)
            {
                // 拼接结果
                result = base[i][num % 10 - 1] + result;
            }
        }
        
        return result;
    }
    
}
