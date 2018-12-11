package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

public class SolutionA implements Solution
{
    
    @Override
    public int maxPathSum(TreeNode root)
    {
        if (null == root)
        {
            return 0;
        }
        
        return dfs(root)[1];
    }
    
    /**
     * 1,总和；2,最大值
     * @param node
     * @return
     */
    private int[] dfs(TreeNode node)
    {
        if (null == node.left)
        {
            if (null == node.right)
            {
                return new int[] {node.val, node.val};
            }
            else
            {
                int[] rightResult = dfs(node.right);
                rightResult[0] += node.val;
                rightResult[1] = Math.max(rightResult[1], Math.max(rightResult[1] + node.val, node.val));
                return rightResult;
            }
        }
        else
        {
            if (null == node.right)
            {
                int[] leftResult = dfs(node.left);
                leftResult[0] += node.val;
                leftResult[1] = Math.max(leftResult[1], Math.max(leftResult[1] + node.val, node.val));
                
                return leftResult;
            }
            else
            {
                int[] leftResult = dfs(node.left);
                int[] rightResult = dfs(node.right);
                
                int[] rootResult = new int[2];
                rootResult[0] = leftResult[0] + rightResult[0] + node.val;
                
                rootResult[1] = Math.max((node.val + Math.max(leftResult[0], rightResult[0])),
                    (Math.max(Math.max(leftResult[1], rightResult[1]), Math.max(rootResult[0], node.val))));
                
                return rootResult;
            }
        }
    }
}
