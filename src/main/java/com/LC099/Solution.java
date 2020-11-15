package com.LC099;

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
    public void recoverTree() {
        thisNode(newTree());

        System.out.println(errorNode[0].val);
        System.out.println(errorNode[1].val);

        int val = errorNode[0].val;
        errorNode[0].val = errorNode[1].val;
        errorNode[1].val = val;
        val+=1;
    }

    private TreeNode[] errorNode = new TreeNode[2];
    private int error_index;

    private void thisNode(TreeNode node) {
        if (node == null) return;
        if (error_index >= 2) return;
        thisNode(node.left);

        stack.put(node);
        if (!stack.check()) {
            if (error_index == 0) {
                errorNode[error_index++] = stack.getNode(0);
                errorNode[error_index] = stack.getNode(1);
            } else {
                errorNode[error_index++] = stack.getNode(1);
            }
        }

        thisNode(node.right);
    }

    private static final Stack stack = new Stack();

    private static class Stack {
        private final TreeNode[] stack = new TreeNode[2];
        private int index;

        public void put(TreeNode node) {
            stack[index] = node;
            index = (index + 1)%2;
        }

        public TreeNode getNode(int i) {
            return stack[(index + i)%2];
        }

        static int i;
        public boolean check() {
            if (i++ == 0) return true;
            return stack[index].val < stack[(index + 1)%2].val;
        }
    }
}
