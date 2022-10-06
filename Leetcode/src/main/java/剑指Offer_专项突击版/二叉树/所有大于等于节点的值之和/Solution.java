package 剑指Offer_专项突击版.二叉树.所有大于等于节点的值之和;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

/**
 * @author Wu
 * @date 2022年10月05日 11:43
 */
public class Solution {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        recur(root);
        return root;
    }

    public void recur(TreeNode root) {
        if (root == null) return;
        recur(root.right);
        sum += root.val;
        root.val = sum;
        recur(root.left);
    }
}
