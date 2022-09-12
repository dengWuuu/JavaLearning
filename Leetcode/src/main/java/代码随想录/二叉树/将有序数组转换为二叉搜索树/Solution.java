package 代码随想录.二叉树.将有序数组转换为二叉搜索树;

import 代码随想录.二叉树.TreeNode;

/**
 * @author Wu
 * @date 2022年09月12日 11:29
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }


    public TreeNode recur(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (right - left) / 2 + left;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recur(nums, left, mid - 1);
        root.right = recur(nums, mid + 1, right);
        return root;
    }
}
