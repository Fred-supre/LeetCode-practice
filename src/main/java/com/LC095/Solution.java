package com.LC095;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    class TreeNode implements Cloneable{
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
        protected TreeNode clone() throws CloneNotSupportedException {
            TreeNode root = (TreeNode) super.clone();
//            root.left = (TreeNode) root.left.clone();
//            root.right = (TreeNode) root.right.clone();
            return root;
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

    @Test
    public void test() throws CloneNotSupportedException {
        List<TreeNode> list = generateTrees(3);

        for (TreeNode node : list) {
            System.out.println(node);
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return myGenerate(1,n);
    }

    private List<TreeNode> myGenerate(int i1, int i2) {
        List<TreeNode> list = new ArrayList<>();
        if (i1 > i2) return null;
        if (i1 == i2) {
            List<TreeNode> p = new ArrayList<>();
            p.add(new TreeNode(i1));
            return p;
        }
        List<TreeNode> leftChildren, rightChildren;
        for (int i = i1; i <= i2; i++) {
            leftChildren = myGenerate(i1, i-1);
            rightChildren = myGenerate(i+1, i2);

            if (leftChildren == null) {
                for (TreeNode rTree : rightChildren) {
                    TreeNode root = new TreeNode(i);
                    root.right = Clone(rTree);
                    list.add(root);
                }
            } else if (rightChildren == null) {
                for (TreeNode lTree : leftChildren) {
                    TreeNode root = new TreeNode(i);
                    root.left = Clone(lTree);
                    list.add(root);
                }
            } else {
                for (TreeNode lTree : leftChildren) {
                    for (TreeNode rTree : rightChildren) {
                        TreeNode root = new TreeNode(i);
                        root.left = Clone(lTree);
                        root.right = Clone(rTree);
                        list.add(root);
                    }
                }
            }
        }
        return list;
    }

    private TreeNode Clone(TreeNode root) {
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val);
        node.left = Clone(root.left);
        node.right = Clone(root.right);

        return node;
    }
}
