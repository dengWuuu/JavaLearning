package 代码随想录.二叉树.找树左下角的值;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月10日 10:18
 */
public class Solution {
    public int ans = 0;
    public int maxLen = Integer.MIN_VALUE;

    public int findBottomLeftValue(TreeNode root) {
        backTrack(root, 0);
        return ans;
    }

    public void backTrack(TreeNode root, int len) {
        if (len > maxLen && root.left == null && root.right == null) {
            ans = root.val;
            maxLen = len;
        }

        if (root.left != null) backTrack(root.left, len + 1);
        if (root.right != null) backTrack(root.right, len + 1);


    }
}
