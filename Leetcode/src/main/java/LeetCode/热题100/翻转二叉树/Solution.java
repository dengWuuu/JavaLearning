package LeetCode.热题100.翻转二叉树;

/**
 * @author Wu
 * @date 2022年08月29日 8:34
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}