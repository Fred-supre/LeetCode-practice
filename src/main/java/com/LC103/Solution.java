package com.LC103;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4, new TreeNode(2), null);
        return root;
    }

    @Test
    public void test() {
        TreeNode root = newTree();

        List<List<Integer>> totalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> lStack = new Stack<>();
        Stack<TreeNode> rStack = new Stack<>();
        lStack.push(root);

        for (int i=1; ; i++) {
            Stack<TreeNode> popStack, pushStack;
            if (i%2 == 1) {
                popStack = lStack;
                pushStack = rStack;
            } else {
                popStack = rStack;
                pushStack = lStack;
            }

            while (!popStack.isEmpty()) {
                TreeNode p = popStack.pop();
                list.add(p.val);
                if (i%2 == 0) {
                    if (p.right != null) pushStack.push(p.right);
                    if (p.left != null) pushStack.push(p.left);
                } else {
                    if (p.left != null) pushStack.push(p.left);
                    if (p.right != null) pushStack.push(p.right);
                }
            }
            totalList.add(list);
            if (pushStack.isEmpty()) break;
            list = new ArrayList<>();
        }

        System.out.println(totalList);
    }
}
