package 代码随想录.二叉树.二叉树的最小深度;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月09日 12:03
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right != null) return minDepth(root.right) + 1;
        if (root.right == null && root.left != null) return minDepth(root.left) + 1;
        if (root.left == null && root.right == null) return 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
