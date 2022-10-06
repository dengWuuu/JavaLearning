package 剑指Offer_专项突击版.二叉树.展平二叉搜索树;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

/**
 * @author Wu
 * @date 2022年10月05日 9:51
 */
public class Solution {
    private TreeNode resNode;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorder(root);
        return dummyNode.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);

        // 在中序遍历的过程中修改节点指向
        resNode.right = node;
        node.left = null;
        resNode = node;

        inorder(node.right);
    }
}