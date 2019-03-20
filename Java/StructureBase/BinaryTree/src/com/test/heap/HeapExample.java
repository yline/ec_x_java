package com.test.heap;

import java.util.List;

import junit.framework.TestCase;

public class HeapExample extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    // 从下至上，以新增为例
    public void testHeapifyUp()
    {
        SolutionHeapifyUp solution = new SolutionHeapifyUp();
        
        List<Integer> dataA = solution.buildTestSource();
        solution.insert(dataA, 1);
        assertSolutionUp(dataA, 1, 9, 21, 33);
        
        List<Integer> dataB = solution.buildTestSource();
        solution.insert(dataB, 11);
        assertSolutionUp(dataB, 9, 11, 21, 33);
        
        List<Integer> dataC = solution.buildTestSource();
        solution.insert(dataC, 25);
        assertSolutionUp(dataC, 9, 21, 25, 33);
        
        List<Integer> dataD = solution.buildTestSource();
        solution.insert(dataD, 125);
        assertSolutionUp(dataD, 9, 21, 33, 125);
    }
    
    private void assertSolutionUp(List<Integer> dataList, int... valueArray)
    {
        assertEquals(dataList.get(14).intValue(), valueArray[0]);
        assertEquals(dataList.get(7).intValue(), valueArray[1]);
        assertEquals(dataList.get(3).intValue(), valueArray[2]);
        assertEquals(dataList.get(1).intValue(), valueArray[3]);
    }
    
    // 从上至下，以删除为例
    public void testHeapifyDown()
    {
        SolutionHeapifyDown solution = new SolutionHeapifyDown();
        
        List<Integer> dataList = solution.buildTestSource();
    }
    
    private void assertSolutionDown(List<Integer> dataList, int[] valueArray)
    {
        
    }
    
    // 堆化；新建堆
    public void testHeapBuild()
    {
        
    }
    
    // 堆，排序
    public void testHeapOrder()
    {
        
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
