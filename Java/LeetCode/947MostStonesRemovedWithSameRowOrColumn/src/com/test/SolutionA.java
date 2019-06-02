package com.test;

import java.util.HashMap;

public class SolutionA
{
    public int removeStones(int[][] stones)
    {
        HashMap<Integer, Integer> rowMap = new HashMap<>(); // null 代表，从未添加过，"大于0"代表，已添加且未被其他值记录进去，"-1"代表，已添加，且已被记录过
        HashMap<Integer, Integer> columnMap = new HashMap<>();
        
        int result = 0;
        for (int i = 0; i < stones.length; i++)
        {
            int row = stones[i][0];
            int column = stones[i][1];
            
            // 一共九种可能性，行3 * 列3 = 9； 遍历即可
            Integer rowState = rowMap.get(row);
            Integer columnState = columnMap.get(column);
            if (null == rowState)
            {
                if (null == columnState)
                {
                    rowMap.put(row, column);
                    columnMap.put(column, row);
                }
                else if (columnState >= 0)
                {
                    result += 1;
                    
                    rowMap.put(row, -1);
                    columnMap.put(column, -1);
                    
                    rowMap.put(columnState, -1);
                }
                else
                {
                    result += 1;
                    
                    rowMap.put(row, -1);
                }
            }
            else if (rowState >= 0)
            {
                if (null == columnState)
                {
                    result += 1;
                    rowMap.put(row, -1);
                    columnMap.put(column, -1);
                    
                    columnMap.put(rowState, -1);
                }
                else if (columnState >= 0)
                {
                    result += 2;
                    rowMap.put(row, -1);
                    columnMap.put(column, -1);
                    
                    rowMap.put(columnState, -1);
                    columnMap.put(rowState, -1);
                }
                else
                {
                    result += 1;
                    
                    rowMap.put(row, -1);
                    
                    columnMap.put(rowState, -1);
                }
            }
            else
            {
                if (null == columnState)
                {
                    result += 1;
                    columnMap.put(column, -1);
                }
                else if (columnState >= 0)
                {
                    result += 1;
                    columnMap.put(column, -1);
                    
                    rowMap.put(columnState, -1);
                }
                else
                {
                    result += 1;
                }
            }
        }
        
        return result;
    }
}
