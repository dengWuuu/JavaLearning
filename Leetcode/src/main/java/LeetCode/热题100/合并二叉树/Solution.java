package LeetCode.热题100.合并二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Wu
 * @date 2022年09月03日 21:24
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode root = new TreeNode(root1.val + root2.val);
        Queue<TreeNode> newRoot = new LinkedList<>();
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        newRoot.add(root);
        left.add(root1);
        right.add(root2);

        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode leftNode = left.poll(), rightNode = right.poll(), newNode = newRoot.poll();
            TreeNode left1 = leftNode.left, left2 = rightNode.left, right1 = leftNode.right, right2 = rightNode.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    System.out.println("left1" + "->" + left1.val + "left2" + "->" + left2.val);
                    TreeNode node = new TreeNode(left1.val + left2.val);
                    newNode.left = node;
                    newRoot.add(node);
                    left.add(left1);
                    right.add(left2);
                }
                if (left2 != null) {
                    System.out.println(1);
                    newNode.left = newOneSubTree(left2);
                }
                if (left1 != null) {
                    System.out.println(1);
                    newNode.left = newOneSubTree(left1);
                }
            }

            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    System.out.println("right1" + "->" + right1.val + "left1" + "->" + right2.val);
                    TreeNode node = new TreeNode(right1.val + right2.val);
                    newNode.right = node;
                    newRoot.add(node);
                    left.add(right1);
                    right.add(right2);
                }
                if (right2 != null) {
                    System.out.println(1);
                    newNode.right = newOneSubTree(right2);
                }
                if (right1 != null) {
                    System.out.println(1);
                    newNode.right = newOneSubTree(right1);
                }
            }
        }
        return root;
    }

    private TreeNode newOneSubTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = newOneSubTree(root.left);
        newRoot.right = newOneSubTree(root.right);
        return newRoot;
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