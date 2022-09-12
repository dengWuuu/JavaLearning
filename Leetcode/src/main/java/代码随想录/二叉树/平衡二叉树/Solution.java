package 代码随想录.二叉树.平衡二叉树;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月10日 9:26
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    public int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        int right = recur(root.right);
        if (Math.abs(left - right) > 1 || left == -1 || right == -1) return -1;
        return Math.max(left, right) + 1;
    }
}
