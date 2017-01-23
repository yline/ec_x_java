package com.test;

public class Solution
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if (null == l1)
        {
            return l2;
        }
        
        if (null == l2)
        {
            return l1;
        }
        
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (null != l1 && null != l2)
        {
            if (l1.val < l2.val)
            {
                temp.next = new ListNode(l1.val);
                temp = temp.next;
                
                l1 = l1.next;
            }
            else
            {
                temp.next = new ListNode(l2.val);
                temp = temp.next;
                
                l2 = l2.next;
            }
        }
        
        // 结束时,对空进行判断
        if (null != l1)
        {
            temp.next = l1;
        }
        
        if (null != l2)
        {
            temp.next = l2;
        }
        
        return result.next;
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
    
    /**
     * <pre>
     * 原题
     * Merge two sorted linked lists and return it as a new list.
     * The new list should be made by splicing together the nodes of the first two lists.
     *
     * 题目大意
     * 合并两个排序链表并返回一个新的列表。新的链表的结果由原先的两个链表结点组成，
     * 也就是不能合并后的链表不能包含新创建的结点。
     *
     * 解题思路
     * 使用头结点root进行辅助操作，创建一个头结点，再使用两个引用指向两个链表的头结点，
     * 将较小的结点值的结点摘下来接到root链表的末尾，同时被摘的链头引用移动到下一个结点，
     * 一直操作，到到原先两个链表中有一个为空，最后再将剩下的结点接到root链表的末尾。
     * 最后返回root的下一个结点，其就为新的链表头。
     * </pre>
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2)
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
}
