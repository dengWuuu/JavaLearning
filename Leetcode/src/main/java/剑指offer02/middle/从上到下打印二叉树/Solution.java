package 剑指offer02.middle.从上到下打印二叉树;

import java.util.*;

/**
 * @author Wu
 * @date 2022年07月29日 11:50
 */
public class Solution {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> deque = new ArrayDeque<>();
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode pop = deque.pollFirst();
            ans.add(pop.val);
            if (root.left != null) {
                deque.add(root.left);
            }
            if (root.right != null) {
                deque.add(root.right);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
