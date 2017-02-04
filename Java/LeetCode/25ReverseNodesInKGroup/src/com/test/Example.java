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
        ListNode node1 = solution.newListNode(1, 2, 3, 4);
        assertEquals("2143", logListNode(solution.reverseKGroup(node1, 2)));
        
        node1 = solution.newListNode(1, 2, 3, 4);
        assertEquals("3214", logListNode(solution.reverseKGroup(node1, 3)));
        
        node1 = solution.newListNode(1, 2, 3, 4);
        assertEquals("1234", logListNode(solution.reverseKGroup(node1, 5)));
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
