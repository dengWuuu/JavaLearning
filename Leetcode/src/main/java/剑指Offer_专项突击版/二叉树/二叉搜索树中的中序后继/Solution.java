package 剑指Offer_专项突击版.二叉树.二叉搜索树中的中序后继;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

/**
 * @author Wu
 * @date 2022年10月05日 10:05
 */
public class Solution {
    TreeNode pre, ans;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        pre = null;
        return recur(root, p);
    }

    public TreeNode recur(TreeNode root, TreeNode p) {
        if (root == null) return null;
        recur(root.left, p);
        if (pre == p) {
            ans = root;
        }
        pre = root;
        recur(root.right, p);
        return ans;
    }
}
