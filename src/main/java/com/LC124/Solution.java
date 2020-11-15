package com.LC124;

import org.junit.Test;

public class Solution {


//    Definition for a binary tree node.
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
    }
    private TreeNode newTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null);
        root.right = new TreeNode(8, new TreeNode(13, null, new TreeNode(1)), new TreeNode(4));
        return root;
    }

    @Test
    public void maxPathSum() {
        TreeNode tree = newTree();

        maxGain(tree);
        System.out.println(maxSum);
    }

    private int maxSum = Integer.MIN_VALUE;

    private int maxGain(TreeNode node) {
        int left, right, all, self;
        self = node.val;
        if (node.left == null) left = Integer.MIN_VALUE; else left = maxGain(node.left);
        if (node.right == null) right = Integer.MIN_VALUE; else right = maxGain(node.right);
        all = (left == Integer.MIN_VALUE? 0 : left) + (right == Integer.MIN_VALUE? 0 : right) + self;

        if (left != Integer.MIN_VALUE) left += self;
        if (right != Integer.MIN_VALUE) right += self;
        int localMax = Integer.max(Integer.max(left, right), Integer.max(all, self));
        maxSum = Integer.max(localMax, maxSum);
        return Integer.max(self, Integer.max(left, right));
    }
}
