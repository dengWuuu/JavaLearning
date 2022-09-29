package 剑指offer02.easy.平衡二叉树;

/**
 * @author Wu
 * @date 2022年08月03日 17:23
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    public int getHeight(TreeNode root) {
        return root == null ? 0 : Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
