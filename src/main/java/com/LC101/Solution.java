package com.LC101;

import org.junit.Test;

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
        root.left = new TreeNode(4, null, new TreeNode(2));
        root.right = new TreeNode(4, new TreeNode(2), null);
        return root;
    }

    @Test
    public void test() {
        TreeNode root = newTree();

        System.out.println(func(root, root));
    }

    private boolean func(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        if (t1.val != t2.val) return false;
        return func(t1.left, t2.right) && func(t1.right, t2.left);
    }

}
