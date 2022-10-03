package 剑指Offer_专项突击版.队列.二叉树最底层最左边的值;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

public class Solution {
    int ans;
    int curHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        ans = root.val;
        dfs(root, 0);
        return ans;
    }


    public void dfs(TreeNode root, int height) {
        if (root == null) return;
        height++;
        if (root.left != null) dfs(root.left, height);
        if (root.right != null) dfs(root.right, height);

        if (height > curHeight) {
            ans = root.val;
            curHeight = height;
        }


    }
}
