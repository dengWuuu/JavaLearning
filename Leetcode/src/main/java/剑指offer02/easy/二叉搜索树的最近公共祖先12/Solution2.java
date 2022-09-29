package 剑指offer02.easy.二叉搜索树的最近公共祖先12;

/**
 * @author Wu
 * @date 2022年08月06日 11:55
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null) return r;
        if (r == null) return l;
        return root;
    }
}
