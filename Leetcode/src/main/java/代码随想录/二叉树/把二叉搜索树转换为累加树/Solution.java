package 代码随想录.二叉树.把二叉搜索树转换为累加树;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月12日 13:56
 */
public class Solution {
    int pre;
    public TreeNode convertBST(TreeNode root) {
        recur(root);
        return root;
    }
    public void recur(TreeNode root) {
        if (root == null) return;
        recur(root.right);
        root.val += pre;
        pre = root.val;
        recur(root.left);
    }
}