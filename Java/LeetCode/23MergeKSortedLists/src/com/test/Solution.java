package com.test;

public class Solution
{
    /**
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists)
    {
        if (null == lists || lists.length == 0)
        {
            return null;
        }
        
        int oldLength = lists.length;
        int newLength;
        while (oldLength > 1)
        {
            newLength = (oldLength + 1) / 2;
            
            for (int i = 0; i < newLength; i++)
            {
                if (2 * i + 1 < oldLength)
                {
                    lists[i] = mergeTwoLists(lists[2 * i], lists[2 * i + 1]);
                }
                else
                {
                    lists[i] = mergeTwoLists(lists[2 * i], null);
                }
            }
            
            oldLength = newLength;
        }
        return lists[0];
    }
    
    /**
     * Merge Two Sorted List
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode head = new ListNode(0); // 创建一个头结点，最后还要删除掉
        ListNode tail = head;
        
        while (l1 != null && l2 != null)
        {
            if (l1.val <= l2.val)
            {
                tail.next = l1;
                l1 = l1.next;
            }
            else
            {
                tail.next = l2;
                l2 = l2.next;
            }
            
            tail = tail.next; // 移动到新的尾结点
        }
        
        tail.next = (l1 != null ? l1 : l2);
        
        return head.next; // head的下一个节点是第一个数据结点
    }
    
    public ListNode newListNode(int... number)
    {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        
        for (int i = 0; i < number.length; i++)
        {
            temp.next = new ListNode(number[i]);
            temp = temp.next;
        }
        
        return result.next;
    }
}
