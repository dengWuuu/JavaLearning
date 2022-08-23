package LeetCode.热题100.从前序与中序遍历序列构造二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年08月23日 16:41
 */
public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int n = preorder.length;
        return recur(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode recur(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
        if (preL > preR) return null;
        TreeNode root = new TreeNode(preorder[preL]);

        int baseIdx = map.get(preorder[preL]);
        int leftSubTreeSize = baseIdx - inL;
        root.left = recur(preorder, inorder, preL + 1, preL + leftSubTreeSize, inL, baseIdx - 1);
        root.right = recur(preorder, inorder, preL + leftSubTreeSize + 1, preR, baseIdx + 1, inR);
        return root;
    }
}
