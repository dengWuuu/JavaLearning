package 剑指offer02.middle.从上到下打印二叉树3;

import java.util.*;

/**
 * @author Wu
 * @date 2022年07月29日 12:56
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    Deque<TreeNode> deque = new ArrayDeque<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return ans;
        }
        deque.push(root);
        int x = 1;
        while (!deque.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode pop = deque.pop();
                if (x % 2 == 0) {
                    tmp.addFirst(pop.val);
                } else {
                    tmp.addLast(pop.val);
                }
                if (pop.left != null) {
                    deque.add(pop.left);
                }
                if (pop.right != null) {
                    deque.add(pop.right);
                }
            }
            ans.add(tmp);
            x++;
        }
        return ans;
    }
}
