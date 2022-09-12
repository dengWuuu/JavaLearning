package 代码随想录.二叉树.验证二叉搜索树;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月11日 9:58
 */
public class Solution {
    Long MAX = Long.MAX_VALUE;
    Long MIN = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return recur(root, MIN, MAX);
    }

    public boolean recur(TreeNode root, Long min, Long max) {
        if (root == null) return true;
        if (root.val < min || root.val > max) return false;
        return recur(root.left, min, (long) root.val) && recur(root.right, (long) root.val, max);
    }
}
