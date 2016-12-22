package com.test;

import java.util.Arrays;

public class Solution
{
    public static final int[] array = {5, 8, 4, 12, 32, -12, -43, 0, 9, 43, -23, 8, -4, 43, 5};
    
    public int[] sortQuick()
    {
        int[] temp = array.clone();
        Arrays.sort(temp);
        return temp;
    }
    
    public int[] sortBubble()
    {
        int[] temp = array.clone();
        for (int i = 0; i < temp.length - 1; i++)
        {
            for (int j = i + 1; j < temp.length; j++)
            {
                if (temp[i] > temp[j])
                {
                    int tempInt = temp[i];
                    temp[i] = temp[j];
                    temp[j] = tempInt;
                }
            }
        }
        return temp;
    }
}
