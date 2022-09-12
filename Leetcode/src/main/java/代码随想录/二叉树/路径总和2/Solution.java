package 代码随想录.二叉树.路径总和2;

import 代码随想录.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月10日 10:37
 */
public class Solution {
    List<List<Integer>> result;
    LinkedList<Integer> path;
    public List<List<Integer>> pathSum (TreeNode root,int targetSum) {
        result = new LinkedList<>();
        path = new LinkedList<>();
        travesal(root, targetSum);
        return result;
    }
    private void travesal(TreeNode root,  int count) {
        if (root == null) return;
        path.offer(root.val);
        count -= root.val;
        if (root.left == null && root.right == null && count == 0) {
            result.add(new LinkedList<>(path));
        }
        travesal(root.left, count);
        travesal(root.right, count);
        path.removeLast(); // 回溯
    }
}