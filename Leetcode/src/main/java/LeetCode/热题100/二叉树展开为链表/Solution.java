package LeetCode.热题100.二叉树展开为链表;

/**
 * @author Wu
 * @date 2022年08月23日 16:56
 */
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) predecessor = predecessor.right;
                predecessor.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }
}
