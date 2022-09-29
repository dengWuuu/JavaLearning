package 剑指offer02.easy.二叉树的镜像;

/**
 * @author Wu
 * @date 2022年07月28日 16:45
 */
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        recur(root);
        return root;
    }

    public void recur(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        recur(root.left);
        recur(root.right);
    }
}
