package LeetCode.热题100.二叉树的最大深度;

/**
 * @author Wu
 * @date 2022年08月23日 16:39
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        return backTrack(root);
    }

    public int backTrack(TreeNode root) {
        if (root == null) return 0;
        return Math.max(backTrack(root.left), backTrack(root.right)) + 1;
    }

}
