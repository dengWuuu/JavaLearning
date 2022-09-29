package 剑指offer02.middle.重建二叉树_middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年07月23日 21:19
 */
public class Solution {
    private final Map<Integer, Integer> index = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            index.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);

    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderL, int preorderR, int inorderL, int inorderR) {
        if (preorderL > preorderR) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderL]);
        int inorderRootIndex = index.get(preorder[preorderL]);
        int leftSubtreeSize = inorderRootIndex - inorderL;

        root.left = myBuildTree(preorder, inorder, preorderL + 1, preorderL + leftSubtreeSize, inorderL, inorderRootIndex - 1);
        root.right = myBuildTree(preorder, inorder, preorderL + leftSubtreeSize + 1, preorderR, inorderRootIndex + 1, inorderR);
        return root;
    }
}
