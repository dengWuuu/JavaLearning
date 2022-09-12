package 代码随想录.二叉树.二叉搜索树的最小绝对差;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月11日 10:08
 */
public class Solution {
    int ans;
    int pre;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        ans = Integer.MAX_VALUE;
        pre = Integer.MAX_VALUE;
        recur(root);
        return ans;
    }

    public void recur(TreeNode root) {
        if (root == null) return;
        recur(root.left);
        if (pre != Integer.MAX_VALUE) {
            ans = Math.min(ans, root.val - pre);
        }
        pre = root.val;
        recur(root.right);
    }
}
