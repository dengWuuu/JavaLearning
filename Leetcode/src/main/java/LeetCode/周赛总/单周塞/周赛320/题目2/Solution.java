package LeetCode.周赛总.单周塞.周赛320.题目2;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年11月20日 9:56
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> all = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        recur(root);
        for (int query : queries) {
            List<Integer> path = new ArrayList<>();
            int[] binary = binary(query);
            if (binary[0] < 0) path.add(-1);
            else path.add(all.get(binary[0]));

            if (binary[1] >= all.size()) path.add(-1);
            else path.add(all.get(binary[1]));
            ans.add(path);
        }
        return ans;

    }

    public int[] binary(int num) {
        int l = 0, r = all.size() - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (all.get(mid) == num) {
                return new int[]{mid, mid};
            } else if (all.get(mid) > num) r = mid - 1;
            else l = mid + 1;
        }
        return new int[]{r, l};
    }

    public void recur(TreeNode root) {
        if (root == null) return;
        recur(root.left);
        all.add(root.val);
        recur(root.right);
    }
}