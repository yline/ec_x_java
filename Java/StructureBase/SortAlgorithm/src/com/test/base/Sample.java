package com.test.base;

import java.util.Arrays;

import com.test.SolutionB;
import com.test.SolutionBubble;
import com.test.SolutionInsert;
import com.test.SolutionSelect;

import junit.framework.TestCase;

public class Sample extends TestCase
{
    
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        // solution = new SolutionB();
        super.setUp();
    }
    
    public void testBubble()
    {
        solution = new SolutionBubble();
        logSolution("Bubble");
    }
    
    public void testInsert()
    {
        solution = new SolutionInsert();
        logSolution("Insert");
    }
    
    public void testSelect()
    {
        solution = new SolutionSelect();
        logSolution("Select");
    }
    
    public void testSort()
    {
        SolutionB solution = new SolutionB();
        System.out.println(Arrays.toString(solution.sortQuick()));
        System.out.println(Arrays.toString(solution.sortHeap()));
        System.out.println(Arrays.toString(solution.sortMerge()));
    }
    
    private void logSolution(String tag)
    {
        Node[] array = Node.createNodeArray();
        System.out.println("-------------------" + tag + "----------------");
        System.out.println("start--" + Arrays.toString(array));
        solution.sort(array);
        System.out.println("finish-" + Arrays.toString(array));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        // solution = null;
        super.tearDown();
    }
}
