package LeetCode.周赛总.单周塞.周赛319.题3;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.*;

class Solution {
    public int minimumOperations(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.pollFirst();
                tmp.add(tmp.size(), poll.val);
                if (poll.left != null) deque.addLast(poll.left);
                if (poll.right != null) deque.addLast(poll.right);
            }
            ans += count(tmp);
        }
        return ans;
    }

    public static int count(List<Integer> tmp) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> sort = new ArrayList<>(tmp);
        Collections.sort(sort);
        for (int i = 0; i < sort.size(); i++) {
            map.put(sort.get(i), i);
        }
        int loops = 0;//循环节个数
        boolean[] flag = new boolean[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            if (!flag[i]) {
                int j = i;
                while (!flag[j]) {
                    flag[j] = true;
                    j = map.get(tmp.get(j));
                }
                loops++;
            }
        }
        return tmp.size() - loops;
    }

    public static void swap(List<Integer> tmp, int i, int j) {
        int temp = tmp.get(i);
        tmp.set(i, tmp.get(j));
        tmp.set(j, temp);
    }
}

//5678
//7685
//7654
//4567

