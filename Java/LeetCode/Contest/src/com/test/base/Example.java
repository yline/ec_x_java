package com.test.base;

import java.util.Arrays;

import com.test.SolutionA;
import com.test.SolutionB;
import com.test.SolutionC;

import junit.framework.TestCase;

public class Example extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testSolutionA()
    {
        
        assertSolution();
    }
    
    private void assertSolution()
    {
        SolutionA solution = new SolutionA();
        
        int[] arrA = new int[] {1, 0, 2, 3, 0, 4, 5, 0};
        solution.duplicateZeros(arrA);
        System.out.println(Arrays.toString(arrA));
        
        SolutionB solutionB = new SolutionB();
        int resultBA = solutionB.shortestPathBinaryMatrix(new int[][] {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}});
        System.out.println(resultBA);
        int resultBB = solutionB.shortestPathBinaryMatrix(new int[][] {{0, 1}, {1, 0}});
        System.out.println(resultBB);
        
        SolutionC solutionC = new SolutionC();
        String resultCA = solutionC.shortestCommonSupersequence("abac", "cab");
        System.out.println(resultCA);
        
        String resultCB = solutionC.shortestCommonSupersequence("bbbaaaba", "bbababbb");
        System.out.println(resultCB);
        
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
