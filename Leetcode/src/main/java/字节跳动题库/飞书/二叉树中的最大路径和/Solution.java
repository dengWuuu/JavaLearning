package 字节跳动题库.飞书.二叉树中的最大路径和;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

/**
 * @author Wu
 * @date 2022年10月31日 19:43
 */
public class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        recur(root);
        return ans;
    }

    public int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        int right = recur(root.right);
        int sum = root.val;
        if (left > 0 && right > 0) {
            sum = left + right + root.val;
        } else if (left > 0) {
            sum = left + root.val;
        } else if (right > 0) sum = right + root.val;
        ans = Math.max(ans, sum);

        if (right < 0 && left < 0) return root.val;
        return Math.max(left, right) + root.val;

    }
}