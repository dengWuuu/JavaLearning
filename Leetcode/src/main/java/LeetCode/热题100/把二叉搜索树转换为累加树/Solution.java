package LeetCode.热题100.把二叉搜索树转换为累加树;

/**
 * @author Wu
 * @date 2022年09月02日 10:25
 */
public class Solution {
    public TreeNode convertBST(TreeNode root) {
        recur(root, 0);
        return root;
    }

    public int recur(TreeNode root, int sum) {
        if (root == null) return sum;
        int recur = recur(root.right, sum);
        root.val +=recur;
        return recur(root.left, root.val);
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