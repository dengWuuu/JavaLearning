package 代码随想录.二叉树.二叉树的最近公共祖先;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月12日 10:04
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recur(root, p, q);
    }


    public TreeNode recur(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p) return p;
        else if (root == q) return q;

        TreeNode left = recur(root.left, p, q);
        TreeNode right = recur(root.right, p, q);
        if (left != null && right != null) return root;
        else if (left != null) return left;
        else return right;
    }
}
