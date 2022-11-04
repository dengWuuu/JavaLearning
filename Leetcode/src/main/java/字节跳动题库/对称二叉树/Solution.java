package 字节跳动题库.对称二叉树;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Wu
 * @date 2022年11月03日 19:46
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        else if (l == null) return false;
        else if (r == null) return false;
        else {
            return l.val == r.val && recur(l.left, r.right) && recur(l.right, r.left);
        }
    }


    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}