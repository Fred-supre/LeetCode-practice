package com.LC129;

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
        sum(newTree(), 0);
        System.out.println(totalSum);
    }

    private int totalSum;
    private void sum(TreeNode root, int localSum) {
        if (root == null) return;

        localSum = localSum*10 + root.val;
        if (root.left == null && root.right == null) {
            totalSum += localSum;
        } else {
            if (root.left != null) sum(root.left, localSum);
            if (root.right != null) sum(root.right, localSum);
        }
    }
}
