package LeetCode.热题100.打家劫舍3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年08月31日 11:45
 */
public class Solution {


    /**
     * 树形dp解法
     */
    private int[] robTree(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] res = new int[2];

        int[] left = robTree(root.left);
        int[] right = robTree(root.right);

        res[0] = Math.max(left[1], left[0]) + Math.max(right[1], right[0]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

    public int robFunction(TreeNode root) {
        int[] ints = robTree(root);
        return Math.max(ints[0], ints[1]);
    }


    /**
     * 递归解法
     */
    Map<TreeNode, Integer> hashMap = new HashMap<>();

    public int rob(TreeNode root) {
        return recur(root);
    }

    public int recur(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (hashMap.containsKey(root)) return hashMap.get(root);
        int val = root.val;
        //偷此节点的数值
        if (root.left != null) val += recur(root.left.left) + recur(root.left.right);
        if (root.right != null) val += recur(root.right.left) + recur(root.right.right);

        //不偷
        int val2 = recur(root.right) + recur(root.left);
        hashMap.put(root, Math.max(val, val2));
        return Math.max(val, val2);
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