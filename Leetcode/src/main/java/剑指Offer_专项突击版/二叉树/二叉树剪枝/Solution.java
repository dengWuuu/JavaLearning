package 剑指Offer_专项突击版.二叉树.二叉树剪枝;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return recur(root);
    }

    public TreeNode recur(TreeNode root) {
        if (root == null) return null;
        root.left = recur(root.left);
        root.right = recur(root.right);
        if (root.val == 0) {
            if (root.left == null && root.right == null) return null;
        }
        return root;
    }
}