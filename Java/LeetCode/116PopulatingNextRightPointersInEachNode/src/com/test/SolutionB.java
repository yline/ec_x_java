package com.test;

import com.test.base.Solution;
import com.test.base.TreeLinkNode;

public class SolutionB implements Solution
{
    
    @Override
    public void connect(TreeLinkNode root)
    {
        if (root == null)
            return;
        while (root.left != null)
        {
            TreeLinkNode node = root;
            while (node != null)
            {
                node.left.next = node.right;
                if (node.next != null)
                    node.right.next = node.next.left;
                node = node.next;
            }
            root = root.left;
        }
    }
}
