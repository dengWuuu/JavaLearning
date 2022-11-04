package 字节跳动题库.求根节点到叶节点数字之和;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

/**
 * @author Wu
 * @date 2022年11月04日 20:01
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
            return;
        }

        recur(root.left, sum);
        recur(root.right, sum);
    }
}
