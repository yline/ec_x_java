package com.test.backtracking;

/**
 * 八皇后问题
 * 皇后能横向，纵向和斜向移动，在这三条线上的其他棋子都可以被吃掉
 * 
 * 将八位皇后放在一张8x8的棋盘上，使得每位皇后都无法吃掉别的皇后，
 * （即任意两个皇后都不在同一条横线，竖线和斜线上），问一共有多少种摆法。
 * 
 * 参考：https://www.jianshu.com/p/65c8c60b83b8
 * 
 * @author YLine
 *
 * 2019年4月15日 下午1:55:35
 */
public class EightQueens
{
    public void eightQueen()
    {
        Board board = new Board();
        int x = 0, y = 0;
        
        board.add(x, y, 0);
    }
    
    private boolean tryIndex(Board board, int x, int y)
    {
        int value = 0;
        while (value < 8 && value >= 0)
        {
            board.add(x, y, value);
            if (!board.isEnd())
            {
                int[] next = board.next(x, y);
                if (null != next)
                {
                    value++;
                    x = next[0];
                    y = next[1];
                    
                    continue;
                }
            }
            
            board.remove(x, y, value);
            value--;
        }
        
        return false;
    }
    
    /**
     * .实现棋盘
     */
    private static class Board
    {
        private int filledSize = 0;
        private final int[][] sBoard = new int[8][8];
        
        public Board()
        {
            filledSize = 0;
            for (int i = 0; i < sBoard.length; i++)
            {
                for (int j = 0; j < sBoard[i].length; j++)
                {
                    sBoard[i][j] = -1;
                }
            }
        }
        
        /**
         * 往棋盘，放置一个皇后
         * @param x x位置
         * @param y y位置
         * @param value 当前第几个
         */
        public void add(int x, int y, int value)
        {
            // 当前行
            for (int i = 0; i < sBoard.length; i++)
            {
                addInner(i, y, value);
                ;
            }
            
            // 当前列
            for (int j = 0; j < sBoard.length; j++)
            {
                addInner(x, j, value);
            }
            
            // 4个斜线
            int sx = x, sy = y;
            while (sx < 8 && sy < 8)
            {
                addInner(sx, sy, value);
                sx++;
                sy++;
            }
            
            sx = x;
            sy = y;
            while (sx >= 0 && sy < 8)
            {
                addInner(sx, sy, value);
                sx--;
                sy++;
            }
            
            sx = x;
            sy = y;
            while (sx >= 0 && sy >= 0)
            {
                addInner(sx, sy, value);
                sx--;
                sy--;
            }
            
            sx = x;
            sy = y;
            while (sx < 8 && sy >= 0)
            {
                addInner(sx, sy, value);
                sx++;
                sy--;
            }
        }
        
        private void addInner(int x, int y, int value)
        {
            if (sBoard[x][y] == -1)
            {
                filledSize++;
                sBoard[x][y] = value;
            }
        }
        
        /**
         * 从棋盘中，移除一个皇后
         * @param x x位置
         * @param y y位置
         * @param value 当前第几个
         */
        public void remove(int x, int y, int value)
        {
            // 当前行
            for (int i = 0; i < sBoard.length; i++)
            {
                removeInner(i, y, value);
            }
            
            // 当前列
            for (int j = 0; j < sBoard.length; j++)
            {
                removeInner(x, j, value);
            }
            
            // 4个斜线
            int sx = x, sy = y;
            while (sx < 8 && sy < 8)
            {
                removeInner(sx, sy, value);
                sx++;
                sy++;
            }
            
            sx = x;
            sy = y;
            while (sx >= 0 && sy < 8)
            {
                removeInner(sx, sy, value);
                sx--;
                sy++;
            }
            
            sx = x;
            sy = y;
            while (sx >= 0 && sy >= 0)
            {
                removeInner(sx, sy, value);
                sx--;
                sy--;
            }
            
            sx = x;
            sy = y;
            while (sx < 8 && sy >= 0)
            {
                removeInner(sx, sy, value);
                sx++;
                sy--;
            }
        }
        
        private void removeInner(int x, int y, int value)
        {
            if (sBoard[x][y] == value)
            {
                filledSize--;
                sBoard[x][y] = -1;
            }
        }
        
        /**
         * 棋盘，是否满状态
         * @return
         */
        public boolean isEnd()
        {
            return (filledSize == 64);
        }
        
        /**
         * 依据当前填充的位置，找到下一个可以填充的位置
         * @param startX
         * @param startY
         * @return
         */
        public int[] next(int startX, int startY)
        {
            // 当前行
            for (int i = startX; i < sBoard.length; i++)
            {
                if (sBoard[i][startY] == -1)
                {
                    return new int[] {i, startY};
                }
            }
            
            // 剩余所有行
            for (int i = 0; i < sBoard.length; i++)
            {
                for (int j = startY + 1; j < sBoard.length; j++)
                {
                    if (sBoard[i][j] == -1)
                    {
                        return new int[] {i, j};
                    }
                }
            }
            
            return null;
        }
    }
    
}
