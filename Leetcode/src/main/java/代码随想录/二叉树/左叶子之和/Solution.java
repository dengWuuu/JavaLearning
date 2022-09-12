package 代码随想录.二叉树.左叶子之和;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月10日 10:06
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return recur(root);
    }

    public int recur(TreeNode root) {
        if (root == null) return 0;
        int mid = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            mid = root.left.val;
        }
        return recur(root.left) + recur(root.right) + mid;
    }
}
