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
        /*
        System.out.println("递归全排列");
        String str[] = {"1", "2", "3"}; // , "4", "5"
        solution.arrange(str, 0, str.length);
        
        System.out.println("非递归全排列");
        int nums[] = {5, 2, 3, 4, 1};
        solution.nextPermutation(nums);
        
        System.out.println("非递归全排列 All");
        int numsB[] = {5, 2, 3, 4, 1};
        solution.pernutation(numsB);
        */
        System.out.println("非递归全排列 All");
        int numsC[] = {1, 1};
        solution.nextPermutation(numsC);
        for (int i = 0; i < numsC.length; i++)
        {
            System.out.print(numsC[i] + "  ");
        }
        System.out.println();
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
