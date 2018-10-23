package com.test;

import com.test.base.Solution;

public class SolutionB implements Solution
{
    @Override
    public void solveSudoku(char[][] board)
    {
        solveSudokudfs(board);
    }
    
    private static boolean solveSudokudfs(char[][] board)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] == '.')
                {
                    for (int k = 1; k <= 9; k++)
                    {
                        board[i][j] = (char)(k + '0');//尝试
                        if (isValid(board, i, j) && solveSudokudfs(board))
                            return true;
                        board[i][j] = '.';//回退
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * @param i 当前行 位
     * @param j 当前列 位
     * @return 是否合法
     */
    private static boolean isValid(char[][] board, int i, int j)
    {
        // 列
        for (int k = 0; k < 9; k++)
        {
            if (k != j && board[i][k] == board[i][j])
            {
                return false;
            }
        }
        
        // 行
        for (int k = 0; k < 9; k++)
        {
            if (k != i && board[k][j] == board[i][j])
            {
                return false;
            }
        }
        
        // 3 * 3
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++)
        {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++)
            {
                if ((row != i || col != j) && board[row][col] == board[i][j])
                {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}
