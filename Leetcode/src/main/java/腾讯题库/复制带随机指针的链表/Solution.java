package 腾讯题库.复制带随机指针的链表;


import java.util.List;

/**
 * @author Wu
 * @date 2022年11月22日 17:04
 */
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head, newHead;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        newHead = head.next;

        cur = head;
        while (cur != null) {
            Node next = cur.next;
            next.random = cur.random == null ? null : cur.random.next;
            cur.next = next.next;
            if (next != null) {
                cur = next.next;
                next.next = cur.next;
            }
        }
        return newHead;
    }

    public void print(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}