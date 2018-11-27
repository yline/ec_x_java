package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 函數：
 * 
 * @author YLine
 *
 * 2018年11月26日 下午9:09:22
 */
public class SolutionA implements Solution
{
    @Override
    public int minDepth(TreeNode root)
    {
        if (null == root)
        {
            return 0;
        }
        
        return dfs(root);
    }
    
    private int dfs(TreeNode node)
    {
        if (null == node.left && null == node.right)
        {
            return 1;
        }
        
        if (null == node.left || null == node.right)
        {
            return 2;
        }
        
        return 1 + Math.min(dfs(node.left), dfs(node.right));
    }
}
