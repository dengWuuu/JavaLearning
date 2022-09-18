package 代码随想录.贪心.监控二叉树;

/**
 * @author Wu
 * @date 2022年09月17日 11:07
 */
public class Solution {
    int ans = 0;

    public int minCameraCover(TreeNode root) {
        int recur = recur(root);
        if (recur == 0) ans++;
        return ans;
    }

    /**
     * 0：该节点无覆盖
     * 1：本节点有摄像头
     * 2：本节点有覆盖
     *
     * @param root 节点
     * @return 012
     */
    public int recur(TreeNode root) {
        if (root == null) return 2;
        int left = recur(root.left);
        int right = recur(root.right);

        if (left == 2 && right == 2) return 0;

        if (left == 0 || right == 0) {
            ans++;
            return 1;
        }

        if (left == 1 || right == 1) return 2;
        return -1;
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