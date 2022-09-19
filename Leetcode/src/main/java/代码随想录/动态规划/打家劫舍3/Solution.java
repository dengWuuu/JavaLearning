package 代码随想录.动态规划.打家劫舍3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月19日 20:21
 */
public class Solution {

    //树形dp的做法

    public int robMain(TreeNode root) {
        int[] ints = recurByTreeDp(root);
        return Math.max(ints[0], ints[1]);
    }

    /**
     * 规定 dp【0】是不抢这间屋子的最大值，dp【1】是抢这间屋子的最大值
     *
     * @param root
     * @return
     */
    public int[] recurByTreeDp(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        if (root.left == null && root.right == null) return new int[]{0, root.val};
        int[] left = recurByTreeDp(root.left);
        int[] right = recurByTreeDp(root.right);

        int[] ans = new int[2];
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ans[1] = left[0] + right[0] + root.val;
        return ans;
    }


    //下面为记忆化递归的做法
    Map<TreeNode, Integer> cache = new HashMap<>();

    public int rob(TreeNode root) {
        return recur(root);
    }

    public int recur(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        //偷此节点的数
        int sum = root.val;
        if (root.left != null) sum += recur(root.left.left) + recur(root.left.right);
        if (root.right != null) sum += recur(root.right.left) + recur(root.right.right);

        //不偷此节点的值
        int val = 0;
        if (root.left != null) val += recur(root.left);
        if (root.right != null) val += recur(root.right);
        int max = Math.max(val, sum);
        cache.put(root, max);
        return max;
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