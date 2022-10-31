package 字节跳动题库.飞书.二叉树最大宽度;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wu
 * @date 2022年10月31日 20:28
 */
public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new ArrayDeque<>();

        int ans = 0;

        deque.add(root);

        while (!deque.isEmpty()) {

        }

        return ans;
    }
}