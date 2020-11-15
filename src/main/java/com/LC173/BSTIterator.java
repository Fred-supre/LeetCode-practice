package com.LC173;

import java.util.Stack;

public class BSTIterator {
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

    private TreeNode tree;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        tree = root;
        stack = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = stack.pop();
        if (res.right != null) {
            TreeNode p = res.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }
        return res.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
