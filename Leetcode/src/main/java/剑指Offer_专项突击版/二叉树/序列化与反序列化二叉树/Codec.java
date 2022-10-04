package 剑指Offer_专项突击版.二叉树.序列化与反序列化二叉树;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wu
 * @date 2022年10月04日 11:59
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder ans = new StringBuilder();
        ans.append(root.val).append(",");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                ans.append(node.left.val).append(",");
            } else ans.append("null").append(",");

            if (node.right != null) {
                queue.add(node.right);
                ans.append(node.right.val).append(",");
            } else ans.append("null").append(",");

        }
        return ans.substring(0, ans.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.isBlank()) return null;
        Deque<TreeNode> deque = new ArrayDeque<>();
        String[] split = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        deque.add(root);
        for (int i = 1; i < split.length - 1; i += 2) {
            String left = split[i];
            String right = split[i + 1];
            TreeNode node = null;
            if (!deque.isEmpty()) node = deque.pollFirst();
            else break;
            TreeNode l, r;
            if (!left.equals("null") && !right.equals("null")) {
                l = new TreeNode(Integer.parseInt(left));
                r = new TreeNode(Integer.parseInt(right));
                node.left = l;
                node.right = r;
                deque.addLast(l);
                deque.addLast(r);
            } else if (!left.equals("null")) {
                l = new TreeNode(Integer.parseInt(left));
                node.left = l;
                deque.addLast(l);
            } else if (!right.equals("null")) {
                r = new TreeNode(Integer.parseInt(right));
                node.right = r;
                deque.addLast(r);
            }
        }
        return root;
    }
}
