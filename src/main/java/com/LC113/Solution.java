package com.LC113;

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
        root.left = new TreeNode(1, null, new TreeNode(5));
        root.right = new TreeNode(4, new TreeNode(2), null);
        return root;
    }

    @Test
    public void test() {
        totalList = new ArrayList<>();
        System.out.println(path(newTree(), 9, new Stack<Integer>()));
        System.out.println(totalList);
    }

    List<List<Integer>> totalList;
    public boolean path(TreeNode root, int sum, Stack<Integer> list) {
        if (root == null) return false;
        list.push(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                totalList.add(Clone(list));
            }
            list.pop();
            return (root.val == sum);
        }

        if (root.left == null) {
            boolean a = path(root.right, sum - root.val, list);
            list.pop();
            return a;
        } else if (root.right == null) {
            boolean b = path(root.left, sum - root.val, list);
            list.pop();
            return b;
        } else {
            boolean a = path(root.right, sum - root.val, list);
            boolean b = path(root.left, sum - root.val, list);
            list.pop();
            return a || b;
        }
    }

    private List<Integer> Clone(Stack<Integer> list) {
        return new ArrayList<Integer>(list);
    }
}
