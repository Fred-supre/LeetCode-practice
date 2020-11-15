package com.LC098;

import org.junit.Test;

import java.util.Stack;

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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(5,null, null);
//        root.right = new TreeNode(8, new TreeNode(13, null, new TreeNode(1)), new TreeNode(4));
        return root;
    }

    @Test
    public void test() {
        boolean res = isValidBST(newTree(), Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.println(res);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        boolean left = true, right = true;

        if (root.left == null && root.right == null) return (root.val < max && root.val > min);

        if (!(root.val < max && root.val > min)) return false;
        if (root.left != null) left = isValidBST(root.left, min, root.val);
        if (!left) return false;
        if (root.right != null) right = isValidBST(root.right, root.val, max);
        return right;
    }

    @Test
    public void test2() {
        TreeNode p = newTree();

        Stack<TreeNode> stack = new Stack<>();
        long lastNum = Long.MIN_VALUE;

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (lastNum != Long.MIN_VALUE && (lastNum >= p.val)) {System.out.println(false);return;}
                else {lastNum = p.val;}
                p = p.right;
            }
        }
        System.out.println(true);
        return;
    }
}
