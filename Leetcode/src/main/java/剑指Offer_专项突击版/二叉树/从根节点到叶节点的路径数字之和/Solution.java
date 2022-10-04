package 剑指Offer_专项突击版.二叉树.从根节点到叶节点的路径数字之和;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

/**
 * @author Wu
 * @date 2022年10月04日 14:20
 */
public class Solution {
    int total = 0;

    public int sumNumbers(TreeNode root) {
        recur(root, 0);
        return total;
    }

    public void recur(TreeNode root, int sum) {
        if (root == null) return;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            total += sum;
        }
        recur(root.left, sum);
        recur(root.right, sum);
    }
}
