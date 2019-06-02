package com.test;

public class SolutionB
{
    public int maxEqualRowsAfterFlips(int[][] matrix)
    {
        if (matrix.length == 0)
        {
            return 0;
        }
        
        boolean[] needCheckArray = new boolean[matrix[0].length];
        // 列
        for (int i = 0; i < matrix[0].length; i++)
        {
            int pSize = 0; // 1的个数
            int nSize = 0; // 0的个数
            
            // 行
            for (int j = 0; j < matrix.length; j++)
            {
                if (matrix[j][i] == 1)
                {
                    pSize++;
                }
            }
            nSize = matrix.length - pSize;
            
            if (pSize == 0 || nSize == 0)
            {
                needCheckArray[i] = false; // 本列不需要检查 
            }
            else if (pSize > nSize)
            {
                needCheckArray[i] = true; // 本列需要检查，并且翻转
                
                for (int j = 0; j < matrix.length; j++)
                {
                    matrix[j][i] = (matrix[j][i] == 0 ? 1 : 0);
                }
            }
            else
            {
                needCheckArray[i] = true; // 本列需要检查
            }
        }
        return 0;
        
    }
    
}
