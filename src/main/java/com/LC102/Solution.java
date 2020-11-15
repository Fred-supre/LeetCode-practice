package com.LC102;

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
        root.left = new TreeNode(1);
        root.right = new TreeNode(4, new TreeNode(2), null);
        return root;
    }
    @Test
    public void test() {
        System.out.println(levelOrder(newTree()));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode Null = new TreeNode(0);

        List<List<Integer>> totalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        queue.offer(Null);

        while (true) {
            TreeNode p = queue.poll();
            if (p == Null) {
                totalList.add(list);
                if (queue.isEmpty()) break;
                queue.offer(Null);
                list = new ArrayList<>();
                continue;
            }
            list.add(p.val);
            if (p.left != null) queue.offer(p.left);
            if (p.right != null) queue.offer(p.right);
        }

        return totalList;
    }
}
