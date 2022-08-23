package LeetCode.热题100.验证二叉搜索树;

/**
 * @author Wu
 * @date 2022年08月23日 12:55
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long lower, long higher) {
        if (root == null) return true;

        if (root.val <= lower || root.val >= higher) return false;

        return helper(root.left, lower, root.val) && helper(root.right, root.val, higher);
    }
}
