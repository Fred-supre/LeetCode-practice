package com.LC108;

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
    public void sortedArrayToBST() {
        int[] nums = new int[]{-10,-3,0,5,9};

        TreeNode root = buildNode(nums, 0, nums.length - 1);
        System.out.println(root);
    }

    private TreeNode buildNode(int[] nums, int i1, int i2) {
        if (i1 > i2) return null;

        TreeNode root = new TreeNode(nums[(i1+i2)/2]);
        if (i1 == i2) return root;
        root.left = buildNode(nums, i1, (i1+i2)/2 - 1);
        root.right = buildNode(nums, (i1+i2)/2 + 1, i2);

        return root;
    }
}
