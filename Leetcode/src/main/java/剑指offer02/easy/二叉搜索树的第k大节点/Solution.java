package 剑指offer02.easy.二叉搜索树的第k大节点;

/**
 * @author Wu
 * @date 2022年08月03日 16:23
 */
public class Solution {
    int count = 1;
    int ans;
    public int kthLargest(TreeNode root, int k) {
        recur(root, k);
        return ans;
    }
    public void recur(TreeNode root, int k) {
        if (root.right != null) {
            recur(root.right, k);
        }
        if (count++ == k) {
            ans = root.val;
        }
        if (root.left != null) {
            recur(root.left, k);
        }
    }
}
