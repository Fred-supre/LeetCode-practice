package com.LC094;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public TreeNode(int val, TreeNode left, TreeNode right) {
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
        root.left = new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null);
        root.right = new TreeNode(8, new TreeNode(13, null, new TreeNode(1)), new TreeNode(4));
        return root;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }

        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                list.add(p.val);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }

        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode p = root;
        TreeNode lastNode = null;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        while (!stack.isEmpty()) {
            p = stack.pop();
            if (p.right == null || p.right == lastNode) {
                list.add(p.val);
                lastNode = p;
            } else {
                stack.push(p);
                p = p.right;
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
            }
        }

        return list;
    }

    @Test
    public void test() {
        List list = postorderTraversal(newTree());
        System.out.println(list);
    }
}
