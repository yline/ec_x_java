package com.test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution
{
    private StringBuffer stringBuffer = new StringBuffer();
    
    public void init()
    {
        stringBuffer = new StringBuffer();
    }
    
    public String getResult()
    {
        return stringBuffer.toString();
    }
    
    public int getNodeNumber(TreeNode<String> node)
    {
        if (null == node)
        {
            return 0;
        }
        
        return getNodeNumber(node.getLeftNode()) + getNodeNumber(node.getRightNode()) + 1;
    }
    
    public int getNodeNumberNonRecursive(TreeNode<String> node)
    {
        int i = 0;
        
        Queue<TreeNode<String>> queue = new LinkedList<>();
        TreeNode<String> root = node;
        
        queue.add(root);
        
        while (!queue.isEmpty())
        {
            TreeNode<String> temp = queue.poll();
            i++;
            
            if (null != temp.getLeftNode())
            {
                queue.add(temp.getLeftNode());
            }
            
            if (null != temp.getRightNode())
            {
                queue.add(temp.getRightNode());
            }
        }
        
        return i;
    }
    
    public int getDepth(TreeNode<String> node)
    {
        if (null == node)
        {
            return -1;
        }
        
        return Math.max(getDepth(node.getLeftNode()), getDepth(node.getRightNode())) + 1;
    }
    
    public int getDepthNonRecursive(TreeNode<String> node)
    {
        if (null == node)
        {
            return 0;
        }
        
        TreeNode<String> special = new TreeNode<String>("");
        Queue<TreeNode<String>> queue = new LinkedList<>();
        
        queue.offer(node);
        queue.offer(special);
        
        int depth = -1;
        while (!queue.isEmpty())
        {
            TreeNode<String> curr = queue.poll();
            if (curr == special)
            {
                depth++;
                if (!queue.isEmpty())
                { // 使用DummyNode来区分不同的层， 如果下一层不是为空，则应该在尾部加DummyNode.
                    queue.offer(special);
                }
            }
            
            if (curr.getLeftNode() != null)
            {
                queue.offer(curr.getLeftNode());
            }
            
            if (curr.getRightNode() != null)
            {
                queue.offer(curr.getRightNode());
            }
        }
        
        return depth;
    }
}
