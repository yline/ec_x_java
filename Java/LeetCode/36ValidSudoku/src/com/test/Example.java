package com.test;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
        solution = new Solution();
    }
    
    public void testSolution()
    {
        char[][] arrayA = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, 
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, 
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, 
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
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
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
