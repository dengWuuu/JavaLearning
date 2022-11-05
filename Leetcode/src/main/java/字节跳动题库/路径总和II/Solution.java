package 字节跳动题库.路径总和II;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return ans;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> path) {
        path.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(path));
        }
        if (root.left != null) dfs(root.left, targetSum, path);
        if (root.right != null) dfs(root.right, targetSum, path);
        path.remove(path.size() - 1);
    }
}
