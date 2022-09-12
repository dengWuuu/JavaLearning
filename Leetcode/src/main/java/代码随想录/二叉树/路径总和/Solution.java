package 代码随想录.二叉树.路径总和;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月10日 10:24
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return backTrack(root, 0, targetSum);
    }

    public boolean backTrack(TreeNode root, int sum, int targetSum) {
        if (root == null) return false;
        sum += root.val;
        if (sum == targetSum && root.left == null && root.right == null) return true;
        return backTrack(root.left, sum, targetSum) || backTrack(root.right, sum, targetSum);
    }
}
