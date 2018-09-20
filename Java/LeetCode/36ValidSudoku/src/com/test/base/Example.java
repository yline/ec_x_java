package com.test.base;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private SolutionA solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
        solution = new SolutionA();
    }
    
    public void testSolution()
    {
        char[][] arrayA = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        assertEquals(true, solution.isValidSudoku(arrayA));
        
        char[][] arrayB = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        assertEquals(false, solution.isValidSudoku(arrayB));
    }
    
    public void testValidLine()
    {
        char[] arrayA = {'1', '2', '-', '-', '-', '-'};
        assertEquals(true, solution.isValidLine(arrayA));
        
        char[] arrayB = {'1', '1', '-', '-', '-', '-'};
        assertEquals(false, solution.isValidLine(arrayB));
    }
    
    public void testValidLine2()
    {
        char[] arrayA = {'1', '2', '-', '-', '-', '-'};
        assertEquals(true, solution.isValidLine2(arrayA));
        
        char[] arrayB = {'1', '1', '-', '-', '-', '-'};
        assertEquals(false, solution.isValidLine2(arrayB));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
