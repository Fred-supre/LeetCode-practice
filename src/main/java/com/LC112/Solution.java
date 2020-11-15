package com.LC112;

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
        System.out.println(hasPathSum(newTree(), 4));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (sum <= 0) return false;
        if (root.left == null && root.right == null) return (root.val == sum);

        if (root.left == null) {
            return hasPathSum(root.right, sum - root.val);
        } else if (root.right == null) {
            return hasPathSum(root.left, sum - root.val);
        } else {
            return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
        }
    }
}
