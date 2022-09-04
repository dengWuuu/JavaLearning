package LeetCode.热题100.二叉树的直径;

/**
 * @author Wu
 * @date 2022年09月02日 10:40
 */
public class Solution {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        findMax(root);
        return ans - 1;
    }

    public int findMax(TreeNode root) {
        if (root == null) return 0;
        int left = findMax(root.left);
        int right = findMax(root.right);
        ans = Math.max(left + right + 1, ans);
        return Math.max(left, right) + 1;
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