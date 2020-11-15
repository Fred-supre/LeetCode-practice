package com.LC111;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
//        root.left = new TreeNode(1);
        root.right = new TreeNode(4, new TreeNode(2), null);
        return root;
    }

    @Test
    public void test() {
        System.out.println(minDepth(newTree()));
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Integer.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    @Test
    public void test2() {
        TreeNode root = newTree();

        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode Null = new TreeNode(0);

        queue.offer(root);
        queue.offer(Null);

        int num = 1;

        while (true) {
            TreeNode p = queue.poll();
            if (p == Null) {
                num++;
                queue.offer(Null);
                continue;
            }
            if (p.left == null && p.right == null) break;
            if (p.left != null) queue.offer(p.left);
            if (p.right != null) queue.offer(p.right);
        }

        System.out.println(num);
    }
}
