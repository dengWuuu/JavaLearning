package 代码随想录.二叉树.二叉搜索树中的搜索;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月11日 9:54
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
