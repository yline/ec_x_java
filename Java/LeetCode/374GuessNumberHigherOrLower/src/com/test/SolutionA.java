package com.test;

import com.test.base.Solution;

public class SolutionA extends Solution
{
    @Override
    public int guessNumber(int n)
    {
        int left = 1, right = n;
        
        long value = right;
        int result = guess((int)value);
        while (result != 0)
        {
            if (result == 1)
            {
                left = (int)value;
            }
            else
            {
                right = (int)value;
            }
            value = (left + right) >> 1;
            result = guess((int)value);
        }
        return (int)value;
    }
}
