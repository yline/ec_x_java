package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.ListNode;
import com.test.base.Solution;

/**
 * 解题思路：
 * 将链表转成ArrayList，然后比较
 * 
 * 时间复杂度
 * n
 * 
 * 空间复杂度为n
 * 
 * 问题：
 * leetcode跑出来，结果不太对
 * 
 * @author YLine
 *
 * 2018年7月24日 下午4:33:17
 */
public class SolutionA implements Solution
{
    
    @Override
    public boolean isPalindrome(ListNode head)
    {
        if (null == head)
        {
            return true;
        }
        
        List<Integer> nodeArrayList = new ArrayList<>();
        while (null != head)
        {
            nodeArrayList.add(head.val);
            head = head.next;
        }
        
        return isArrayPalindrome(nodeArrayList);
    }
    
    private boolean isArrayPalindrome(List<Integer> nums)
    {
        int length = nums.size();
        int left = (length - 1) / 2, right = length / 2;
        while (left >= 0)
        {
            if (nums.get(left) != nums.get(right))
            {
                return false;
            }
            left--;
            right++;
        }
        
        return true;
    }
    
}
