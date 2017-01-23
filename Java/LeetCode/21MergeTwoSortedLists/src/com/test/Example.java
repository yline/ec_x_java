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
        ListNode node11 = solution.newListNode(1, 3, 5, 7, 9);
        ListNode node12 = solution.newListNode(2, 4, 6, 8, 10);
        ListNode result1 = solution.mergeTwoLists(node11, node12);
        
        logListNode(node11);
        logListNode(node12);
        logListNode(result1);
        
        assertEquals("12345678910", logListNode(result1));
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
