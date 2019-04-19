package com.test;

import com.test.backtracking.EightQueens;

import junit.framework.TestCase;

public class BacktrackingSample extends TestCase
{
    public void testEightQueens()
    {
        System.out.println("-------- EightQueens -------");
        EightQueens queens = new EightQueens();
        queens.eightQueen();
        assertEquals(92, queens.getValue());
    }
}
