package com.test;

import junit.framework.TestCase;

public class Example extends TestCase
{
    public static final String PRE = "ABDEHICFJGK";
    
    public static final String MIDDLE = "DBHEIAFJCKG";
    
    public static final String AFTER = "DHIEBJFKGCA";
    
    public static final String LEVEL = "ABCDEFGHIJK";
    
    private Solution solution;
    
    private TreeNode<String> parentNode;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
        solution = new Solution();
        parentNode = init();
    }
    
    // 初始化二叉树  
    private TreeNode<String> init()
    {
        TreeNode<String> A = new TreeNode<String>("A");
        
        TreeNode<String> B = new TreeNode<String>("B");
        TreeNode<String> C = new TreeNode<String>("C");
        
        TreeNode<String> D = new TreeNode<String>("D");
        TreeNode<String> E = new TreeNode<String>("E");
        TreeNode<String> F = new TreeNode<String>("F");
        TreeNode<String> G = new TreeNode<String>("G");
        
        TreeNode<String> H = new TreeNode<String>("H");
        TreeNode<String> I = new TreeNode<String>("I");
        TreeNode<String> J = new TreeNode<String>("J");
        TreeNode<String> K = new TreeNode<String>("K");
        
        A.setLeftNode(B);
        A.setRightNode(C);
        
        B.setLeftNode(D);
        B.setRightNode(E);
        C.setLeftNode(F);
        C.setRightNode(G);
        
        E.setLeftNode(H);
        E.setRightNode(I);
        F.setRightNode(J);
        G.setLeftNode(K);
        
        return A;
    }
    
    public void testNodeNumber()
    {
        assertEquals(PRE.length(), solution.getNodeNumber(parentNode));
        assertEquals(PRE.length(), solution.getNodeNumberNonRecursive(parentNode));
    }
    
    public void testNodeLevel()
    {
        assertEquals(3, solution.getDepth(parentNode));
        assertEquals(3, solution.getDepthNonRecursive(parentNode));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
