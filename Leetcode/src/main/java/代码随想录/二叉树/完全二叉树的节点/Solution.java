package 代码随想录.二叉树.完全二叉树的节点;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月09日 14:19
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;
        while (left != null) {
            left = left.left;
            leftDepth++;
        }

        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        if (rightDepth == leftDepth) {
            return (2 << leftDepth) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
