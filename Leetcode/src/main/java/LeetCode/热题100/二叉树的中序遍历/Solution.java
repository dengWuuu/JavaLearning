package LeetCode.热题100.二叉树的中序遍历;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月22日 16:26
 */
public class Solution {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();

    public List<Integer> inorderTraversal(TreeNode root) {
//        helper(root);  递归调用
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            ans.add(pop.val);
            pop = pop.right;
            while (pop != null) {
                stack.push(pop);
                pop = pop.left;
            }
        }
        return ans;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        ans.add(root.val);
        helper(root.right);
    }
}
