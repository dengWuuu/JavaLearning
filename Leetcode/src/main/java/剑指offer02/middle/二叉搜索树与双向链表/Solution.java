package 剑指offer02.middle.二叉搜索树与双向链表;

/**
 * @author Wu
 * @date 2022年07月30日 14:52
 */
public class Solution {
    Node pre;
    Node first;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        recur(root);
        first.left = pre;
        pre.right = first;
        return first;
    }

    public void recur(Node root) {
        if (root == null) {
            return;
        }
        recur(root.left);
        if (pre != null) {
            pre.right = root;
        } else {
            first = root;
        }
        root.left = pre;
        pre = root;
        recur(root.right);
    }
}
