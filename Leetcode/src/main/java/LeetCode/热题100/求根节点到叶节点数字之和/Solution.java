package LeetCode.热题100.求根节点到叶节点数字之和;

/**
 * @author Wu
 * @date 2022年08月24日 12:57
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return recur(root,0);
    }

    public int recur(TreeNode root, int val) {
        if (root == null) return 0;
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            return val;
        } else {
            return recur(root.left, val) + recur(root.right, val);
        }
    }
}
