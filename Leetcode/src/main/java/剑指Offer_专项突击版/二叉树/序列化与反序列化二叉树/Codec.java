package 剑指Offer_专项突击版.二叉树.序列化与反序列化二叉树;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.pollFirst();
            if (treeNode.val == -1001) {
                sb.append("null,");
                continue;
            }
            sb.append(treeNode.val).append(",");
            deque.addLast(Objects.requireNonNullElseGet(treeNode.left, () -> new TreeNode(-1001)));
            deque.addLast(Objects.requireNonNullElseGet(treeNode.right, () -> new TreeNode(-1001)));
        }
        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}
