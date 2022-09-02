package LeetCode.热题100.路径总和III;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月01日 9:35
 */
public class Solution {
    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return ans;
    }

    public void dfs(TreeNode root, long targetSum) {
        if (root == null) return;
        targetSum -= root.val;
        if (targetSum == 0) {
            ans++;
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }
}

class Solution2 {
    int targetSum = 0;
    Map<Long, Integer> prefix = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        prefix.put(0L, 1); //前缀和为0的路径有一个
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, long cur) {
        if (root == null) {
            return 0;
        }
        cur += root.val;

        int res = prefix.getOrDefault(cur - targetSum, 0);
        prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);
        res += dfs(root.left, cur);
        res += dfs(root.right, cur);
        prefix.put(cur, prefix.get(cur) - 1);
        return res;
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
