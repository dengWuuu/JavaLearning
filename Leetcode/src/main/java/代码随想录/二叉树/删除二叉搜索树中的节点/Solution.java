package 代码随想录.二叉树.删除二叉搜索树中的节点;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月12日 11:04
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }


    public TreeNode delete(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val > key) {
            root.left = delete(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = delete(root.right, key);
            return root;
        } else {
            if (root.left == null && root.right == null) return null;
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            root.right = delete(root.right, cur.val);
            cur.left = root.left;
            cur.right = root.right;
            return cur;
        }
    }
}
