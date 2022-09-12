package 代码随想录.二叉树.从中序与后序遍历序列构造二叉树;

import 代码随想录.二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月10日 10:38
 */
public class Solution {
    Map<Integer, Integer> cache = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            cache.put(inorder[i], i);
        }
        int n = inorder.length;
        return build(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int inorderL, int inorderR, int postorderL, int postorderR) {
        if (postorderL > postorderR) return null;

        TreeNode root = new TreeNode(postorder[postorderR]);
        int rootIdx = cache.get(postorder[postorderR]);
        int rightSubTreeSize = inorderR - rootIdx;

        root.left = build(inorder, postorder, inorderL, rootIdx - 1, postorderL, postorderR - rightSubTreeSize - 1);
        root.right = build(inorder, postorder, rootIdx + 1, inorderR, postorderR - rightSubTreeSize, postorderR - 1);

        return root;
    }
}
