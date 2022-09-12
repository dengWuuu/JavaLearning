package 代码随想录.二叉树.合并二叉树;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月11日 9:45
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode root = new TreeNode(0);
        root.val = root1.val + root2.val;
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}
