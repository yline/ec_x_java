package com.test;

/**
 * 两个队列相加(假设其中一条为结果,另一条往这个上面填上)
 * @author YLine
 *
 * 2016年12月15日 下午6:48:27
 */
/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @author YLine
 *
 * 2016年12月22日 下午1:21:36
 */
public class Solution
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        if (l1 == null)
        {
            return l2;
        }
        
        if (l2 == null)
        {
            return l1;
        }
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode root = new ListNode(0); // 头结点
        ListNode r = root; // 这种赋值就是地址赋值
        r.next = p1; // 这一个赋值,会导致r 和 root都改变内容
        
        int carry = 0; // 初始进位
        int sum;
        while (p1 != null && p2 != null)
        {
            sum = p1.val + p2.val + carry;
            p1.val = sum % 10; // 本位的结果
            carry = sum / 10; // 本次进位
            
            r.next = p1; // 间接修改root的当前位置的 val
            r = r.next; // r向前移动一格,r对应root的地址也变化了
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        if (p1 == null)
        {
            r.next = p2;
        }
        else
        {
            r.next = p1;
        }
        
        // 最后一次相加还有进位
        if (carry == 1)
        {
            // 开始时r.next是第一个要相加的结点
            while (r.next != null)
            {
                sum = r.next.val + carry;
                r.next.val = sum % 10;
                carry = sum / 10;
                r = r.next;
            }
            
            // 都加完了还有进位，就要创建一个新的结点
            if (carry == 1)
            {
                r.next = new ListNode(1);
            }
        }
        
        return root.next;
    }
}
