package 剑指offer02.middle.二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年07月30日 10:12
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return ans;
    }

    public void recur(TreeNode root, int tar) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        tar -= root.val;
        if (root.left == null && root.right == null && tar == 0) {
            ans.add(new LinkedList<>(tmp));
        }
        recur(root.left, tar);
        recur(root.right, tar);
        tmp.removeLast();
    }
}
