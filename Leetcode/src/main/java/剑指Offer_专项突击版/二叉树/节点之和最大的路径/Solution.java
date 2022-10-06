package 剑指Offer_专项突击版.二叉树.节点之和最大的路径;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.Map;

/**
 * @author Wu
 * @date 2022年10月04日 14:58
 */
public class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        ans = root.val;
        recur(root);
        return ans;
    }

    public int recur(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        int left = -1001, right = -1001;
        if (root.left != null) left = recur(root.left);
        if (root.right != null) right = recur(root.right);
        int data = root.val + left + right;
        ans = Math.max(right + root.val, Math.max(left + root.val, Math.max(root.val, Math.max(Math.max(left, right), Math.max(data, ans)))));
        return Math.max(root.val, Math.max(left + root.val, right + root.val));
    }
}