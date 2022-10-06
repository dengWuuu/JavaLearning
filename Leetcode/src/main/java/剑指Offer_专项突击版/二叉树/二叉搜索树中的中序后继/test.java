package 剑指Offer_专项突击版.二叉树.二叉搜索树中的中序后继;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

/**
 * @author Wu
 * @date 2022年10月05日 11:29
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(1);

        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root3.left = root5;

        System.out.println(solution.inorderSuccessor(root, root5));
    }
}
