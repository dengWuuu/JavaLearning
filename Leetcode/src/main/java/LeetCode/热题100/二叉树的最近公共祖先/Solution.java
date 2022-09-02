package LeetCode.热题100.二叉树的最近公共祖先;

import LeetCode.热题100.反转链表.ListNode;

/**
 * @author Wu
 * @date 2022年08月29日 8:51
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return backTrack(root, p, q);
    }

    public TreeNode backTrack(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = backTrack(root.left, p, q);
        TreeNode right = backTrack(root.right, p, q);

        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}