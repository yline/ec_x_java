package com.test;

import junit.framework.TestCase;

public class OrderExample extends TestCase
{
    private OrderSolution orderSolution;
    
    private TreeNode<String> parentNode;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
        orderSolution = new OrderSolution();
        parentNode = init();
    }
    
    // 初始化二叉树  
    public TreeNode<String> init()
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
    
    public void testSolutionPreOrder()
    {
        orderSolution.initOrder();
        orderSolution.preOrder(parentNode);
        System.out.println("testSolutionPreOrder = " + orderSolution.getResult());
        
        assertEquals("ABDEHICFJGK", orderSolution.getResult());
    }
    
    public void testSolutionPreOrderNonRecursive()
    {
        orderSolution.initOrder();
        orderSolution.preOrderNonRecursive(parentNode);
        System.out.println("testSolutionPreOrderNonRecursive = " + orderSolution.getResult());
        
        assertEquals("ABDEHICFJGK", orderSolution.getResult());
    }
    
    public void testSolutionPreOrderNonRecursive2()
    {
        orderSolution.initOrder();
        orderSolution.preOrderNonRecursive(parentNode);
        System.out.println("testSolutionPreOrderNonRecursive2 = " + orderSolution.getResult());
        
        assertEquals("ABDEHICFJGK", orderSolution.getResult());
    }
    
    public void testSolutionMiddleOrder()
    {
        orderSolution.initOrder();
        orderSolution.middleOrder(parentNode);
        System.out.println("testSolutionMiddleOrder = " + orderSolution.getResult());
        
        assertEquals("DBHEIAFJCKG", orderSolution.getResult());
    }
    
    public void testSolutionMiddleOrderNonRecursive()
    {
        orderSolution.initOrder();
        orderSolution.middleOrderNonRecursive(parentNode);
        System.out.println("testSolutionMiddleOrderNonRecursive = " + orderSolution.getResult());
        
        assertEquals("DBHEIAFJCKG", orderSolution.getResult());
    }
    
    public void testSolutionAfterOrder()
    {
        orderSolution.initOrder();
        orderSolution.afterOrder(parentNode);
        System.out.println("testSolutionAfterOrder = " + orderSolution.getResult());
        
        assertEquals("DHIEBJFKGCA", orderSolution.getResult());
    }
    
    public void testSolutionAfterOrderNonRecursive()
    {
        orderSolution.initOrder();
        orderSolution.afterOrderNonRecursive(parentNode);
        System.out.println("testSolutionAfterOrderNonRecursive = " + orderSolution.getResult());
        
        assertEquals("DHIEBJFKGCA", orderSolution.getResult());
    }
    
    public void testSolutionLeverOrder()
    {
        orderSolution.initOrder();
        orderSolution.levelOrder(parentNode);
        System.out.println("testSolutionLeverOrder = " + orderSolution.getResult());
        
        assertEquals("ABCDEFGHIJK", orderSolution.getResult());
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        orderSolution = null;
        super.tearDown();
    }
}
