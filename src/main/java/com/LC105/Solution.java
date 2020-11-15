package com.LC105;

import org.junit.Test;

public class Solution {


//    Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

    @Test
    public void buildTree() {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};

        TreeNode tree = buildNode(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1);
        System.out.println(tree);
    }

    private TreeNode buildNode(int[] preorder, int[] inorder, int p1, int p2, int i1, int i2) {
        if (p1 > p2) return null;
        if (p1 == p2) return new TreeNode(preorder[p1]);

        TreeNode root = new TreeNode(preorder[p1]);
        int i;
        for (i = i1; ; i++) {
            if (inorder[i] == preorder[p1]) break;
        }
        int leftNum = i - i1;
        int rightNum = i2 - i;
        root.left = buildNode(preorder,inorder,p1+1,p1+leftNum,i1,i-1);
        root.right = buildNode(preorder,inorder,p1+leftNum+1,p2,i+1,i2);
        return root;
    }
}
