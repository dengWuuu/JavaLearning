package 剑指offer02.middle.二叉搜索树的后序遍历序列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wu
 * @date 2022年07月29日 15:30
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    public boolean verifyPost(int[] postorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int parent = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > parent) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i]) parent = stack.pop();
            stack.push(postorder[i]);
        }
        return true;
    }
}