package 剑指Offer_专项突击版.队列.二叉树每层的最大值;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pollFirst();
                max = Math.max(max, pop.val);
                if (pop.left != null) deque.addLast(pop.left);
                if (pop.right != null) deque.addLast(pop.right);
            }
            ans.add(max);
        }
        return ans;
    }
}
