package 字节跳动题库.飞书.从前序与中序遍历序列构造二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年10月29日 18:52
 */
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int n = preorder.length - 1;
        return build(preorder, inorder, 0, n, 0, n);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
        if (preL > preR) return null;
        TreeNode root = new TreeNode(preorder[preL]);

        int rootIdx = map.get(preorder[preL]);
        int leftSize = rootIdx - inL;


        root.left = build(preorder, inorder, preL + 1, preL + leftSize, inL, rootIdx - 1);
        root.right = build(preorder, inorder, preL + leftSize + 1, preR, rootIdx + 1, inR);

        return root;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}