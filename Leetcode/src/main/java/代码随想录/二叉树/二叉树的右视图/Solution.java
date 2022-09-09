package 代码随想录.二叉树.二叉树的右视图;

import 代码随想录.二叉树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月09日 11:11
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) deque.push(root);
        List<Integer> ans = new LinkedList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pop();
                if (i == size - 1) ans.add(node.val);
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
        }
        return ans;
    }
}