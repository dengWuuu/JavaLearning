package 剑指Offer_专项突击版.队列.往完全二叉树添加节点;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class CBTInserter {
    TreeNode root;
    Deque<TreeNode> deque = new LinkedList<>();

    public CBTInserter(TreeNode root) {
        this.root = root;
        deque.addLast(root);
        //层序便利
        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.peekFirst();
            if (treeNode.left != null && treeNode.right != null) {
                deque.addLast(treeNode.left);
                deque.addLast(treeNode.right);
                deque.pollFirst();
            } else {
                if (treeNode.left != null) deque.addLast(treeNode.left);
                if (treeNode.right != null) deque.addLast(treeNode.right);
                break;
            }
        }
    }

    public int insert(int v) {
        TreeNode newNode = new TreeNode(v);
        while (!deque.isEmpty()) {
            TreeNode peek = deque.peekFirst();
            if (peek.left != null && peek.right != null) {
                deque.pollFirst();
            } else if (peek.left == null) {
                peek.left = newNode;
                deque.addLast(newNode);
                return peek.val;
            } else {
                peek.right = newNode;
                TreeNode treeNode = deque.pollFirst();
                deque.addLast(newNode);
                return treeNode.val;
            }
        }
        return -1;
    }

    public TreeNode get_root() {
        return root;
    }
}
