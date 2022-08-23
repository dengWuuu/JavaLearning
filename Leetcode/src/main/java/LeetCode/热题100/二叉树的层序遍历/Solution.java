package LeetCode.热题100.二叉树的层序遍历;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月23日 16:29
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    Deque<TreeNode> deque = new ArrayDeque<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return ans;
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> path = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pop();
                path.add(treeNode.val);
                if (treeNode.left != null) deque.add(treeNode.left);
                if (treeNode.right != null) deque.add(treeNode.right);
            }

            ans.add(new ArrayList<>(path));
        }
        return ans;
    }
}
