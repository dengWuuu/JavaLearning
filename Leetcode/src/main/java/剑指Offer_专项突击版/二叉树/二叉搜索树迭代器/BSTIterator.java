package 剑指Offer_专项突击版.二叉树.二叉搜索树迭代器;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wu
 * @date 2022年10月05日 22:51
 */
public class BSTIterator {
    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new LinkedList<>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}
