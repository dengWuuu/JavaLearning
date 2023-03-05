package LeetCode.周赛总.单周塞.周赛335.题2;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                sum += pop.val;
                if (pop.left != null) deque.add(pop.left);
                if (pop.right != null) deque.add(pop.right);
            }
            list.add(sum);
        }
        if (list.size() < k) return -1;
        Collections.sort(list);
        return list.get(list.size() - k);

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
