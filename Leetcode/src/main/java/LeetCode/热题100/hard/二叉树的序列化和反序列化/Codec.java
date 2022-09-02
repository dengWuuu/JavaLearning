package LeetCode.热题100.hard.二叉树的序列化和反序列化;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Wu
 * @date 2022年08月29日 22:39
 */
public class Codec {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
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
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] split = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);
        int n = split.length, idx = 1;
        while (idx < n) {
            TreeNode node = queue.poll();
            if (!split[idx].equals("null")) {
                TreeNode treeNode = new TreeNode(Integer.parseInt(split[idx]));
                node.left = treeNode;
                queue.add(treeNode);
            }
            idx++;
            if (!split[idx].equals("null")) {
                TreeNode treeNode = new TreeNode(Integer.parseInt(split[idx]));
                node.right = treeNode;
                queue.add(treeNode);
            }
            idx++;
        }
        return root;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        System.out.println(serialize(root));

        System.out.println(deserialize("1,2,3,null,null,4,5"));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}