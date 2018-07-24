package com.test.base;

import com.test.SolutionA;

import junit.framework.TestCase;

/**
 * 严重怀疑正确answer
 */
public class Example extends TestCase
{
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
        solution = new SolutionA();
    }
    
    public void testSolution()
    {
        ListNode nodeA = new ListNode(1);
        nodeA.next = new ListNode(2);
        assertEquals(false, solution.isPalindrome(nodeA));
        
        ListNode nodeB = new ListNode(1);
        nodeB.next = new ListNode(2);
        nodeB.next.next = new ListNode(2);
        nodeB.next.next.next = new ListNode(1);
        assertEquals(true, solution.isPalindrome(nodeB));
        
        ListNode nodeC = new ListNode(-129);
        nodeC.next = new ListNode(-129);
        assertEquals(true, solution.isPalindrome(nodeB));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
