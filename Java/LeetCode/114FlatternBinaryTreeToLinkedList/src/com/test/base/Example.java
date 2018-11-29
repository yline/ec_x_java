package com.test.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testSolutionA()
    {
        solution = new SolutionA();
        assertSolution();
    }
    
    private void assertSolution()
    {
        // A
        TreeNode rootA = new TreeNode(5);
        
        TreeNode leftA1 = new TreeNode(4);
        TreeNode rightA1 = new TreeNode(8);
        rootA.left = leftA1;
        rootA.right = rightA1;
        
        TreeNode leftLeftA2 = new TreeNode(11);
        leftA1.left = leftLeftA2;
        
        TreeNode rightLeftA2 = new TreeNode(13);
        TreeNode rightRightA2 = new TreeNode(4);
        rightA1.left = rightLeftA2;
        rightA1.right = rightRightA2;
        
        leftLeftA2.left = new TreeNode(7);
        leftLeftA2.right = new TreeNode(2);
        rightRightA2.left = new TreeNode(5);
        rightRightA2.right = new TreeNode(1);
        
        List<List<Integer>> resultA = new ArrayList<>();
        resultA.add(Arrays.asList(5, 4, 11, 2));
        resultA.add(Arrays.asList(5, 8, 4, 5));
        
        solution.flatten(rootA);
        log(rootA);
    }
    
    private void log(TreeNode root)
    {
        List<Integer> data = new ArrayList<>();
        while (null != root)
        {
            data.add(root.val);
            root = root.right;
        }
        System.out.println(Arrays.toString(data.toArray()));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
