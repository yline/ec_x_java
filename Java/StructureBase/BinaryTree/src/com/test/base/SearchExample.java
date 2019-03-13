package com.test.base;

import com.test.search.SolutionSearchLookup;

import junit.framework.TestCase;

/**
 * 二叉查找树，测试
 * @author YLine
 *
 * 2019年3月12日 下午6:13:07
 */
public class SearchExample extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    // 查找
    public void testLoopup()
    {
        TreeNode<Integer> rootNode = DataSource.createSearchTreeNode();
        SolutionSearchLookup solution = new SolutionSearchLookup();
        
        assertSolution(null, solution.find(rootNode, 1));
        assertSolution(new TreeNode<Integer>(2), solution.find(rootNode, 2));
        assertSolution(new TreeNode<Integer>(5), solution.find(rootNode, 5));
        assertSolution(new TreeNode<Integer>(6), solution.find(rootNode, 6));
        assertSolution(null, solution.find(rootNode, 9));
        assertSolution(new TreeNode<Integer>(10), solution.find(rootNode, 10));
        assertSolution(new TreeNode<Integer>(16), solution.find(rootNode, 16));
        assertSolution(null, solution.find(rootNode, 19));
    }
    
    // 插入
    public void testInsert()
    {
        
    }
    
    private void assertSolution(TreeNode<Integer> expected, TreeNode<Integer> actual)
    {
        if (null == expected)
        {
            assertEquals(expected, actual);
        }
        else
        {
            assertEquals(expected.getData(), actual.getData());
        }
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
