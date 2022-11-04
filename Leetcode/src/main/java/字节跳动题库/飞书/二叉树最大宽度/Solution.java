package 字节跳动题库.飞书.二叉树最大宽度;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月31日 20:28
 */
public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 1;
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size(), wide = queue.peekLast().id - queue.peekFirst().id + 1; // 每一层的宽度 = 最右节点编号 - 最左节点编号 + 1
            ans = Math.max(ans, wide);
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                TreeNode treeNode = node.treeNode;
                int id = node.id;
                if (treeNode.left != null) queue.add(new Node(treeNode.left, 2 * id + 1));
                if (treeNode.right != null) queue.add(new Node(treeNode.right, 2 * id + 2));
            }
        }
        return ans;
    }

}
class Node {
    TreeNode treeNode;
    int id; // 节点在满二叉树中的编号

    public Node(TreeNode treeNode, int id) {
        this.treeNode = treeNode;
        this.id = id;
    }
}
