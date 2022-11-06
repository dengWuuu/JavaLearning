package LeetCode.周赛总.单周塞.周赛317.移除子树后的二叉树高度;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Wu
 * @date 2022年10月30日 11:22
 */
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    boolean flag = false;

    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] ans = new int[queries.length];

        int idx = 0;
        for (int query : queries) {
            flag = false;
            int h = getH(root, query) - 1;
            ans[idx++] = h;
        }
        return ans;
    }

    public int getH(TreeNode root, int num) {
        if (root == null) return 0;
        if (root.val == num) {
            flag = true;
            return 0;
        }
        int left = 0, right = 0, res;
        if (flag) {
            if (root.left != null && map.containsKey(root.left.val)) left = map.get(root.left.val);
            else left = getH(root.left, num);
            if (root.right != null && map.containsKey(root.right.val)) right = map.get(root.right.val);
            else right = getH(root.right, num);
        } else {
            left = getH(root.left, num);
            right = getH(root.right, num);
        }
        res = Math.max(left, right) + 1;
        map.put(root.val, res);
        return res;
    }
}