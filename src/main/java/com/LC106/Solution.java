package com.LC106;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    private TreeNode newTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4, new TreeNode(2), null);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildNode(inorder,postorder,0,inorder.length - 1,0,postorder.length - 1);
    }

    private TreeNode buildNode(int[] inorder, int[] postorder, int i1, int i2, int p1, int p2) {
        if (p1 > p2) return null;
        if (p1 == p2) return new TreeNode(postorder[p1]);

        TreeNode root = new TreeNode(postorder[p2]);
        int i;
        for (i = i1; ; i++) {
            if (inorder[i] == postorder[p2]) break;
        }
        int leftNum = i - i1;
        int rightNum = i2 - i;
        root.left = buildNode(inorder,postorder,i1,i-1,p1,p1+leftNum-1);
        root.right = buildNode(inorder,postorder,i+1,i2,p1+leftNum,p2-1);
        return root;
    }
}
