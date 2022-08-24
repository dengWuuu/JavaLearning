package LeetCode.热题100.hard.二叉树路径最大和;

/**
 * @author Wu
 * @date 2022年08月24日 12:00
 */
public class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        backTrack(root);
        return ans;
    }

    public int backTrack(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(backTrack(root.left), 0);
        int right = Math.max(backTrack(root.right), 0);
        int num = root.val + left + right;
        ans = Math.max(ans, num);
        return root.val + Math.max(left, right);
    }

}
