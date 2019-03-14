package com.test.base;

import java.util.Arrays;
import java.util.List;

import com.test.search.SolutionSearchOrderMiddle;
import com.test.search2.SolutionSearch2Lookup;

import junit.framework.TestCase;

/**
 * 二叉查找树[允许重复数据]，测试
 * @author YLine
 *
 * 2019年3月14日 上午9:52:37
 */
public class Search2Example extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    // 查找
    public void testLookup()
    {
        TreeNode<Integer> root = DataSource.createSearch2TreeNode();
        SolutionSearch2Lookup solution = new SolutionSearch2Lookup();
        
        assertEquals(0, solution.find(root, -1));
        assertEquals(0, solution.find(root, 0));
        assertEquals(1, solution.find(root, 1));
        assertEquals(2, solution.find(root, 2));
        assertEquals(2, solution.find(root, 3));
        assertEquals(1, solution.find(root, 4));
        assertEquals(2, solution.find(root, 5));
        assertEquals(2, solution.find(root, 6));
        assertEquals(2, solution.find(root, 7));
        assertEquals(1, solution.find(root, 8));
        assertEquals(0, solution.find(root, 9));
    }
    
    // 插入
    public void testInsert()
    {
        
    }
    
    // 删除
    public void testDelete()
    {
        
    }
    
    // 中序遍历
    public void testOrderMiddle()
    {
        TreeNode<Integer> rootNode = DataSource.createSearch2TreeNode();
        SolutionSearchOrderMiddle solution = new SolutionSearchOrderMiddle();
        
        List<Integer> result = solution.middlerOrder(rootNode);
        System.out.println(Arrays.toString(result.toArray()));
        for (int i = 1; i < result.size(); i++)
        {
            assert (result.get(i - 1) <= result.get(i));
        }
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
