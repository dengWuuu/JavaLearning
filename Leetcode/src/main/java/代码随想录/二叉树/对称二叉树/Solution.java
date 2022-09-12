package 代码随想录.二叉树.对称二叉树;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月09日 11:49
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;


        return left.val == right.val && recur(left.left, right.right) && recur(left.right, right.left);
    }
}