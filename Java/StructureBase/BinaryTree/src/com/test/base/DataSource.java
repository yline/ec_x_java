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
     * .创建一个二叉查找树(二叉搜索树[满二叉树])
     * @return 二叉树的头
     */
    public static TreeNode<Integer> createSearchTreeNode()
    {
        TreeNode<Integer> v10 = new TreeNode<Integer>(10);
        
        TreeNode<Integer> v5 = new TreeNode<Integer>(5);
        TreeNode<Integer> v15 = new TreeNode<Integer>(15);
        
        TreeNode<Integer> v3 = new TreeNode<Integer>(3);
        TreeNode<Integer> v7 = new TreeNode<Integer>(7);
        TreeNode<Integer> v13 = new TreeNode<Integer>(13);
        TreeNode<Integer> v17 = new TreeNode<Integer>(17);
        
        TreeNode<Integer> v2 = new TreeNode<Integer>(2);
        TreeNode<Integer> v4 = new TreeNode<Integer>(4);
        TreeNode<Integer> v6 = new TreeNode<Integer>(6);
        TreeNode<Integer> v8 = new TreeNode<Integer>(8);
        TreeNode<Integer> v12 = new TreeNode<Integer>(12);
        TreeNode<Integer> v14 = new TreeNode<Integer>(14);
        TreeNode<Integer> v16 = new TreeNode<Integer>(16);
        TreeNode<Integer> v18 = new TreeNode<Integer>(18);
        
        v10.setLeftNode(v5);
        v10.setRightNode(v15);
        
        v5.setLeftNode(v3);
        v5.setRightNode(v7);
        v15.setLeftNode(v13);
        v15.setRightNode(v17);
        
        v3.setLeftNode(v2);
        v3.setRightNode(v4);
        v7.setLeftNode(v6);
        v7.setRightNode(v8);
        v13.setLeftNode(v12);
        v13.setRightNode(v14);
        v17.setLeftNode(v16);
        v17.setRightNode(v18);
        
        return v10;
    }
}
