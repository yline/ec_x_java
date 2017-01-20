package com.test;

import com.test.bean.ListNode;

public class Solution
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        // 定位到位置
        int length = 0;
        ListNode first = head;
        while (null != first)
        {
            first = first.next;
            length++;
        }
        
        // 得到拆分数据
        // 对 first重新 赋值
        first = head;
        
        ListNode parentResult = new ListNode(0);
        ListNode tempResult = parentResult;
        
        int position = length - n;
        
        for (int i = 0; i < position; i++)
        {
            tempResult.next = new ListNode(first.val);
            tempResult = tempResult.next;
            
            first = first.next;
        }
        
        // 拼接 数据
        tempResult.next = first.next;
        
        // logListNode(parentResult.next);
        
        return parentResult.next;
    }
    
    public String logListNode(ListNode node)
    {
        StringBuffer stringBuffer = new StringBuffer();
        while (null != node)
        {
            stringBuffer.append(node.val);
            node = node.next;
        }
        
        return stringBuffer.toString();
    }
}
