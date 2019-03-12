package com.test.base;

public class DataSource
{
    /**
     * .创建一个数据源
     * @return 二叉树的头
     */
    public static TreeNode<String> createTreeNode()
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
    
    /**
     * .创建一个二叉查找树
     * @return 二叉树的头
     */
    public static TreeNode<Integer> createSearchTreeNode()
    {
        
        return null;
    }
}
