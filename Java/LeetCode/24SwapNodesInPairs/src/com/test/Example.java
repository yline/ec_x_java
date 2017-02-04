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
        ListNode node0 = solution.newListNode(1, 2);
        assertEquals("21", logListNode(solution.swapPairs(node0)));
        
        ListNode node1 = solution.newListNode(1, 2, 3, 4);
        assertEquals("2143", logListNode(solution.swapPairs(node1)));
        
        ListNode node2 = solution.newListNode(1, 3, 5, 7);
        assertEquals("3175", logListNode(solution.swapPairs(node2)));
        
        ListNode node3 = solution.newListNode(1, 2, 3, 4, 5);
        assertEquals("21435", logListNode(solution.swapPairs(node3)));
    }
    
    private String logListNode(ListNode node)
    {
        StringBuffer stringBuffer = new StringBuffer();
        
        ListNode temp = node;
        
        while (null != temp)
        {
            stringBuffer.append(temp.val + "");
            temp = temp.next;
        }
        
        String result = stringBuffer.toString();
        
        System.out.println(result);
        
        return result;
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
