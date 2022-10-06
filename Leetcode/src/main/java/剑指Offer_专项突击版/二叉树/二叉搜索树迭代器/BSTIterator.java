package 剑指Offer_专项突击版.二叉树.二叉搜索树迭代器;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator {
    TreeNode dummyHead;
    TreeNode cur;

    public BSTIterator(TreeNode root) {
        TreeNode pre;
        dummyHead = new TreeNode(-1);
        pre = dummyHead;
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode tmp = root;
        while (tmp != null || !deque.isEmpty()) {
            while (tmp != null) {
                deque.addLast(tmp);
                tmp = tmp.left;
            }
            tmp = deque.pollLast();
            pre.right = tmp;
            tmp.left = null;
            pre = tmp;
            tmp = tmp.right;
        }
        cur = dummyHead.right;
    }

    public int next() {
        int val = cur.val;
        cur = cur.right;
        return val;
    }

    public boolean hasNext() {
        return cur != null;
    }
}
