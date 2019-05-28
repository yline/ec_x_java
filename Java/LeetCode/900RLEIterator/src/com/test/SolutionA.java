package com.test;

import com.test.base.RLEIterator;

/**
 * 
 * 
 * @author YLine
 *
 * 2019年5月28日 下午2:08:16
 */
public class SolutionA extends RLEIterator
{
    
    public SolutionA(int[] A)
    {
        super(A);
    }
    
    @Override
    public int next(int n)
    {
        if (index >= length)
        {
            return -1;
        }
        
        if (n < data[index])
        {
            data[index] -= n;
            return data[index + 1];
        }
        else if (n == data[index])
        {
            data[index] = 0;
            int result = data[index + 1];
            index += 2;
            return result;
        }
        else
        {
            int lastSize = data[index];
            data[index] = 0;
            index += 2;
            return next(n - lastSize);
        }
    }
}
