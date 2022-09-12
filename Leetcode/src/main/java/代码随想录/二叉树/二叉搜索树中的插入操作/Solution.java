package 代码随想录.二叉树.二叉搜索树中的插入操作;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月12日 10:56
 */
public class Solution {
    TreeNode pre;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode node = find(root, val);
        if (val > node.val) {
            node.right = new TreeNode(val);
        } else {
            node.left = new TreeNode(val);
        }
        return root;
    }

    public TreeNode find(TreeNode root, int val) {
        if (root == null) return pre;
        pre = root;
        if (root.val > val) return find(root.left, val);
        else return find(root.right, val);
    }
}
