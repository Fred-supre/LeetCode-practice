package com.LC110;

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
        root.right = new TreeNode(4, new TreeNode(2), new TreeNode(7));
        return root;
    }

    @Test
    public void test() {
        checkNode(newTree());
        System.out.println(flag);
    }

    boolean flag = false;
    private int checkNode(TreeNode node) {
        if (flag) return 0;
        if (node == null) return 0;
        int left = checkNode(node.left);
        int right = checkNode(node.right);
        if (left - right > 1 || left - right < -1) flag = true;
        return Integer.max(left, right)+1;
    }
}
