package 字节跳动题库.验证二叉搜索树;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

/**
 * @author Wu
 * @date 2022年11月03日 15:20
 */
public class Solution {
    TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        return recur(root);
    }

    public boolean recur(TreeNode root) {
        if (root == null) return true;
        boolean recur = recur(root.left);
        if (pre != null) {
            if (root.val < pre.val) {
                return false;
            }
        }
        pre = root;

        boolean recur1 = recur(root.right);
        return recur1 && recur;
    }
}