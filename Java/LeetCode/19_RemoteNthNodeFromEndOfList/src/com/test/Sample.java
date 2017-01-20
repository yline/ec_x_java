package com.test;

import com.test.bean.ListNode;

import junit.framework.TestCase;

public class Sample extends TestCase
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
        ListNode node0 = newListNode(new int[] {1, 2, 3, 4, 5});
        ListNode result0 = newListNode(new int[] {1, 2, 3, 5});
        System.out.println(solution.logListNode(node0));
        System.out.println(solution.logListNode(result0));
        assertEquals(solution.logListNode(result0), solution.logListNode(solution.removeNthFromEnd(node0, 2)));
    }
    
    private ListNode newListNode(int[] nums)
    {
        ListNode parentNode = new ListNode(0);
        ListNode tempNode = parentNode;
        
        for (int i = 0; i < nums.length; i++)
        {
            tempNode.next = new ListNode(nums[i]);
            tempNode = tempNode.next;
        }
        
        return parentNode.next;
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
