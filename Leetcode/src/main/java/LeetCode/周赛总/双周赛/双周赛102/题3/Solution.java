package LeetCode.周赛总.双周赛.双周赛102.题3;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Deque<TreeNode[]> d = new ArrayDeque<>();
        d.add(new TreeNode[]{root, new TreeNode(-1)});
        while (!d.isEmpty()) {
            int size = d.size();
            long sum = 0;
            TreeNode[][] list = new TreeNode[size][2];
            for (int i = 0; i < size; i++) {
                TreeNode[] node = d.poll();
                list[i] = node;
                sum += node[0].val;
                if (node[0].left != null) d.add(new TreeNode[]{node[0].left, node[0]});
                if (node[0].right != null) d.add(new TreeNode[]{node[0].right, node[0]});
            }
            int idx = 0;
            while (idx < list.length) {
                if (idx + 1 < list.length && list[idx + 1][1] == list[idx][1]) {
                    int tmp = list[idx][0].val;
                    list[idx][0].val = (int) (sum - list[idx + 1][0].val - list[idx][0].val);
                    list[idx + 1][0].val = (int) (sum - list[idx + 1][0].val - tmp);
                    idx += 2;
                } else {
                    list[idx][0].val = (int) (sum - list[idx][0].val);
                    idx++;
                }
            }
        }

        return root;
    }
}