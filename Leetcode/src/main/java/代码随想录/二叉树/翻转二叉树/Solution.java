package 代码随想录.二叉树.翻转二叉树;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月09日 11:40
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
