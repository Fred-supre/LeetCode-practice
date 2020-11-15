package com.LC104;

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
        root.left = new TreeNode(1);
        root.right = new TreeNode(4, new TreeNode(2), null);
        return root;
    }

    @Test
    public void test() {
        TreeNode root = newTree();
        System.out.println(func(root));
    }

    private int func(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return Integer.max(func(node.left), func(node.right)) + 1;
    }
}
