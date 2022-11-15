package 字节跳动题库.路径总和;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    public boolean dfs(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) return true;
        boolean left = dfs(root.left, targetSum);
        boolean right = dfs(root.right, targetSum);
        return left || right;
    }
}
