package 剑指offer02.easy.对称的二叉树;

/**
 * @author Wu
 * @date 2022年07月28日 16:54
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);

    }

    public boolean helper(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null) {
            return false;
        }
        return L.val == R.val && helper(L.left, R.right) && helper(L.right, R.left);
    }
}
