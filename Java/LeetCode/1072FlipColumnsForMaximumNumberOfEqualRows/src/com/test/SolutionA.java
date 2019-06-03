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

        cacheMatchA = new boolean[matrix.length];
        cacheMatchB = new boolean[matrix.length];
        
        return dfs(matchArray, firstChangeArray, matrix, 1);
    }
    
    private boolean[] cacheMatchA; // 可以当做临时变量看待，之所以创建是为了避免大量的栈内存
    
    private boolean[] cacheMatchB; // 可以当做临时变量看待，之所以创建是为了避免大量的栈内存
    
    /**
     * 
     * 需要递归，藏的好深啊
     * 
     * @param matchArray 前一行，匹配的情况
     * @param firstArray 该行，是否进行了行变换
     * @param valueArray 该列的值
     */
    private int dfs(boolean[] matchArray, boolean[] firstArray, int[][] matrix, int column)
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
                    // A代表，假设该列，全部由1 -> 0之后的情况
                    cacheMatchA[i] = true;
                    cacheMatchB[i] = false;
                    pSize++;
                }
                else
                {
                    // B代表，假设该列，全部由0 -> 0之后的满足情况
                    cacheMatchB[i] = true;
                    cacheMatchA[i] = false;
                    nSize++;
                }
            }
            else
            {
                cacheMatchA[i] = false;
                cacheMatchB[i] = false;
            }
        }
        
        // 已经到达最后一列了
        if (column == matrix[0].length - 1)
        {
            return Math.max(pSize, nSize);
        }
        else
        {
            System.arraycopy(cacheMatchA, 0, matchArray, 0, cacheMatchA.length);
            pSize = dfs(matchArray, firstArray, matrix, column + 1);
            
            System.arraycopy(cacheMatchB, 0, matchArray, 0, cacheMatchB.length);
            nSize = dfs(matchArray, firstArray, matrix, column + 1);
            
            return Math.max(pSize, nSize);
        }
    }
    
}
