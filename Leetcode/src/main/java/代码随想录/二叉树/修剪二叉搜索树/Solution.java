package 代码随想录.二叉树.修剪二叉搜索树;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月12日 11:16
 */
public class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return delete(root, low, high);
    }


    public TreeNode delete(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val < low) {
            return delete(root.right, low, high);
        }
        if (root.val > high) {
            return delete(root.left, low, high);
        }
        root.left = delete(root.left, low, high);
        root.right = delete(root.right, low, high);
        return root;
    }
}
