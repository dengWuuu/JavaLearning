package 代码随想录.二叉树.最大二叉树;

import 代码随想录.二叉树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wu
 * @date 2022年09月10日 11:27
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for (int num : nums) {
            TreeNode node = new TreeNode(num);
            while (!stack.isEmpty() && stack.peek().val < num) {
                node.left = stack.pop();
            }
            if (!stack.isEmpty()) stack.peek().right = node;
            stack.push(node);
        }
        return stack.peekLast();
    }
}
