package com.test;

import java.util.Arrays;

public class SolutionA
{
    public int maxEqualRowsAfterFlips(int[][] matrix)
    {
        if (matrix.length == 0)
        {
            return 0;
        }
        
        // 第一行，全部满足
        boolean[] matchArray = new boolean[matrix.length];
        Arrays.fill(matchArray, true);
        
        // 第一行，是否进行了行变换【将它全部变成0，好了】
        boolean[] firstChangeArray = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++)
        {
            firstChangeArray[i] = (matrix[i][0] == 1);
        }

        int result = matrix.length;
        for (int i = 1; i < matrix[0].length; i++)
        {
            result = check(matchArray, firstChangeArray, matrix, i);
            if (result == 1)
            {
                return 1;
            }
        }
        
        return result;
    }
    
    /**
     * 
     * 需要递归，藏的好深啊
     * 
     * @param matchArray 前一行，匹配的情况
     * @param firstArray 该行，是否进行了行变换
     * @param valueArray 该列的值
     */
    private int check(boolean[] matchArray, boolean[] firstArray, int[][] matrix, int column)
    {
        // 前一个为true时，1的个数，和0的个数
        int pSize = 0, nSize = 0;
        
        // 遍历，找出1和0的较大值
        for (int i = 0; i < matrix.length; i++)
        {
            if (matchArray[i]) // 前一个为true
            {
                // 当前值为，0但进行了行变换，则认为为1；否则为0
                boolean isOne = (firstArray[i] && matrix[i][column] == 0) ||
                    (!firstArray[i] && matrix[i][column] == 1);
                if (isOne)
                {
                    pSize++;
                }
                else
                {
                    nSize++;
                }
            }
        }
        
        if (pSize > nSize)
        {
            // 1的数，更多；将所有为0的值，matchArray置为false
            for (int i = 0; i < matrix.length; i++)
            {
                if (matchArray[i])
                {
                    boolean isOne = (firstArray[i] && matrix[i][column] == 0) ||
                        (!firstArray[i] && matrix[i][column] == 1);
                    if (!isOne)
                    {
                        matchArray[i] = false;
                    }
                }
            }
            
            return pSize;
        }
        else
        {
            // 0的数，更多；将所有为1的值，matchArray置为false
            for (int i = 0; i < matrix.length; i++)
            {
                if (matchArray[i])
                {
                    boolean isOne = (firstArray[i] && matrix[i][column] == 0) ||
                        (!firstArray[i] && matrix[i][column] == 1);
                    if (isOne)
                    {
                        matchArray[i] = false;
                    }
                }
            }
            
            return nSize;
        }
    }
    
}
