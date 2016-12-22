package com.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树大全
 * https://github.com/yuzhangcmu/LeetCode/blob/master/tree/TreeDemo.java
 */
public class OrderSolution
{
    private StringBuffer stringBuffer = new StringBuffer();
    
    public void initOrder()
    {
        stringBuffer = new StringBuffer();
    }
    
    public String getResult()
    {
        return stringBuffer.toString();
    }
    
    /**
     * 先序遍历;递归
     * @param node
     */
    public void preOrder(TreeNode<String> node)
    {
        if (null == node)
        {
            return;
        }
        
        stringBuffer.append(node.getData());
        preOrder(node.getLeftNode());
        preOrder(node.getRightNode());
    }
    
    /**
     * 中序遍历;递归
     * @param node
     */
    public void middleOrder(TreeNode<String> node)
    {
        if (null == node)
        {
            return;
        }
        
        middleOrder(node.getLeftNode());
        stringBuffer.append(node.getData());
        middleOrder(node.getRightNode());
    }
    
    /**
     * 后序遍历;递归
     * @param node
     */
    public void afterOrder(TreeNode<String> node)
    {
        if (null == node)
        {
            return;
        }
        
        afterOrder(node.getLeftNode());
        afterOrder(node.getRightNode());
        stringBuffer.append(node.getData());
    }
    
    /**
     * 先序遍历，非递归
     * 栈 ==> 先进后出
     * @param node
     */
    public void preOrderNonRecursive(TreeNode<String> node)
    {
        if (null == node)
        {
            return;
        }
        
        Stack<TreeNode<String>> stack = new Stack<>();
        stack.push(node);
        
        while (!stack.isEmpty())
        {
            TreeNode<String> temp = stack.pop();
            
            stringBuffer.append(temp.getData());
            
            if (null != temp.getRightNode())
            {
                stack.push(temp.getRightNode());
            }
            
            if (null != temp.getLeftNode())
            {
                stack.push(temp.getLeftNode());
            }
        }
    }
    
    /**
     * 先序遍历，非递归
     * 栈 ==> 先进后出
     * @param node
     */
    public void preOrderNonRecursive2(TreeNode<String> node)
    {
        if (null == node)
        {
            return;
        }
        
        Stack<TreeNode<String>> stack = new Stack<>();
        TreeNode<String> root = new TreeNode<String>(node.getData());
        root = node; // 赋值
        
        while (null != root || !stack.isEmpty())
        {
            while (null != root)
            {
                stringBuffer.append(root.getData());
                stack.push(root); // 先访问再入栈
                
                root = root.getLeftNode();
            }
            
            root = stack.pop();
            root = root.getRightNode();
        }
    }
    
    /**
     * 中序遍历，非递归
     * 栈 ==> 先进后出
     * @param node
     */
    public void middleOrderNonRecursive(TreeNode<String> node)
    {
        if (null == node)
        {
            return;
        }
        
        Stack<TreeNode<String>> stack = new Stack<>();
        TreeNode<String> root = new TreeNode<String>(node.getData());
        root = node; // 赋值
        
        while (null != root || !stack.isEmpty())
        {
            while (null != root)
            {
                stack.push(root); // 先访问再入栈
                
                root = root.getLeftNode();
            }
            
            root = stack.pop();
            stringBuffer.append(root.getData());
            
            root = root.getRightNode();
        }
    }
    
    public void afterOrderNonRecursive(TreeNode<String> node)
    {
        if (null == node)
        {
            return;
        }
        
        Stack<TreeNode<String>> stack = new Stack<>();
        Map<TreeNode<String>, Boolean> map = new HashMap<>();
        TreeNode<String> root = node;
        
        stack.push(root);
        
        while (!stack.isEmpty())
        {
            TreeNode<String> temp = stack.peek(); // 寻找,但不移除
            
            if (null != temp.getLeftNode() && !map.containsKey(temp.getLeftNode()))
            {
                temp = temp.getLeftNode();
                while (null != temp)
                {
                    if (map.containsKey(temp))
                    {
                        break;
                    }
                    else
                    {
                        stack.push(temp);
                    }
                    temp = temp.getLeftNode();
                }
                continue;
            }
            
            if (null != temp.getRightNode() && !map.containsKey(temp.getRightNode()))
            {
                stack.push(temp.getRightNode());
                continue;
            }
            
            // 最后统一,遍历
            TreeNode<String> tempNode = stack.pop();
            map.put(tempNode, true);
            stringBuffer.append(tempNode.getData());
        }
    }
    
    /**
     * 层序遍历;非递归
     * 队列 ==> 先进先出 规则
     * @param node
     */
    public void levelOrder(TreeNode<String> node)
    {
        if (null == node)
        {
            return;
        }
        
        Queue<TreeNode<String>> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty())
        {
            TreeNode<String> temp = queue.poll();
            stringBuffer.append(temp.getData());
            
            if (null != temp.getLeftNode())
            {
                queue.add(temp.getLeftNode());
            }
            
            if (null != temp.getRightNode())
            {
                queue.add(temp.getRightNode());
            }
        }
    }
}
