package 剑指offer02.easy.二叉树的深度;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wu
 * @date 2022年08月03日 17:13
 */
public class Solution {
    Deque<TreeNode> queue = new ArrayDeque<>();

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepthByQueue(TreeNode root) {
        if (root == null) return 0;
        queue.add(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            ans++;
        }
        return ans;
    }
}