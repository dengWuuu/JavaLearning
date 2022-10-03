package 剑指Offer_专项突击版.队列.二叉树的右侧视图;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                if (treeNode.left != null) deque.addLast(treeNode.left);
                if (treeNode.right != null) deque.addLast(treeNode.right);
                if (i == size - 1) ans.add(treeNode.val);
            }
        }
        return ans;
    }
}
