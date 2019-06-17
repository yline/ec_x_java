package com.test;

import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionB
{
    public int shortestPathBinaryMatrix(int[][] grid)
    {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1)
        {
            return -1;
        }
        
        dfs(grid);
        
        // 从头到尾，没有右下角
        if (grid[grid.length - 1][grid.length - 1] == 0)
        {
            return -1;
        }
        return grid[grid.length - 1][grid.length - 1];
    }
    
    private void dfs(int[][] grid)
    {
        // position = x<<7 + y
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        grid[0][0] = 1;
        
        while (!queue.isEmpty())
        {
            int index = queue.poll();
            int x = index >> 7;
            int y = index % 128;
            
            addValue(queue, grid, x - 1, y - 1, grid[x][y]);
            addValue(queue, grid, x - 1, y, grid[x][y]);
            addValue(queue, grid, x - 1, y + 1, grid[x][y]);
            addValue(queue, grid, x, y - 1, grid[x][y]);
            addValue(queue, grid, x, y + 1, grid[x][y]);
            addValue(queue, grid, x + 1, y - 1, grid[x][y]);
            addValue(queue, grid, x + 1, y, grid[x][y]);
            addValue(queue, grid, x + 1, y + 1, grid[x][y]);
        }
    }
    
    private void addValue(Queue<Integer> queue, int[][] grid, int x, int y, int oldResult)
    {
        // x越界
        if (x < 0 || x >= grid.length)
        {
            return;
        }
        
        // y越界
        if (y < 0 || y >= grid[0].length)
        {
            return;
        }
        
        // 添加值
        if (grid[x][y] == 0)
        {
            grid[x][y] = oldResult + 1;
            queue.add((x << 7) + y);
        }
    }
}
