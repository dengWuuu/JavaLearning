package 剑指offer02.easy.从上到下打印二叉树2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Wu
 * @date 2022年07月29日 12:11
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    Deque<TreeNode> deque = new ArrayDeque<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;

        }
        deque.add(root);
        while (!deque.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < deque.size(); i++) {
                TreeNode pop = deque.pop();
                tmp.add(pop.val);
                if(pop.left != null) {
                    deque.add(pop.left);
                }
                if(pop.right != null) {
                    deque.add(pop.right);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}
