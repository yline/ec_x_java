package com.test.base;

import java.util.Arrays;

import com.test.SolutionB;
import com.test.SolutionBubble;
import com.test.SolutionInsert;
import com.test.SolutionMerge;
import com.test.SolutionMergeB;
import com.test.SolutionSelect;
import com.test.SolutionShell;

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
    
    // 冒泡排序
    public void testBubble()
    {
        solution = new SolutionBubble();
        logSolution("Bubble");
    }
    
    // 插入排序
    public void testInsert()
    {
        solution = new SolutionInsert();
        logSolution("Insert");
    }
    
    // 选择排序
    public void testSelect()
    {
        solution = new SolutionSelect();
        logSolution("Select");
    }
    
    // 希尔排序
    public void testShell()
    {
        solution = new SolutionShell();
        logSolution("Shell");
    }
    
    // 并归排序
    public void testMerge()
    {
        solution = new SolutionMerge(); // 递推
        logSolution("Merge");
        
        solution = new SolutionMergeB(); // 递归
        logSolution("MergeB");
    }
    
    // 待分析的排序方式
    public void testSort()
    {
        SolutionB solution = new SolutionB();
        System.out.println("------------------- sort other ----------------");
        System.out.println(Arrays.toString(solution.sortQuick()));
        System.out.println(Arrays.toString(solution.sortHeap()));
    }
    
    private void logSolution(String tag)
    {
        Node[] array = Node.createNodeArray();
        System.out.println("-------------------" + tag + "----------------");
        System.out.println("start--" + Arrays.toString(array));
        solution.sort(array);
        System.out.println("finish-" + Arrays.toString(array));
        
        // 校验是增量的数组
        Node temp = array[0];
        for (int i = 1; i < array.length; i++)
        {
            assert temp.value <= array[i].value;
            temp = array[i];
        }
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        // solution = null;
        super.tearDown();
    }
}
