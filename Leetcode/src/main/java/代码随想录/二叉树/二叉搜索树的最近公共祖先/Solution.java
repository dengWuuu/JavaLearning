package 代码随想录.二叉树.二叉搜索树的最近公共祖先;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月12日 10:15
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recur(root, p, q);
    }

    public TreeNode recur(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) return root;
        if (root.val > p.val && root.val > q.val) {
            return recur(root.left, p, q);
        }

        if (root.val < p.val && root.val < q.val) {
            return recur(root.right, p, q);
        }
        return root;
    }
}
