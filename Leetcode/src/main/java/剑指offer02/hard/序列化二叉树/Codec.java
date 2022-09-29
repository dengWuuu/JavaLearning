package 剑指offer02.hard.序列化二叉树;

import java.util.*;

public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>() {{
            add(root);
        }};
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String[] split = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int x = 1;
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (!Objects.equals(split[x], "null")) {
                poll.left = new TreeNode(Integer.parseInt(split[x]));
                deque.add(poll.left);
            }
            x++;
            if (!Objects.equals(split[x], "null")) {
                poll.right = new TreeNode(Integer.parseInt(split[x]));
                deque.add(poll.right);
            }
            x++;
        }
        return root;
    }
}