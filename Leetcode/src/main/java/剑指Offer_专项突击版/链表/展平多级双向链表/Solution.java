package 剑指Offer_专项突击版.链表.展平多级双向链表;

import 剑指Offer_专项突击版.链表.ListNode;

/**
 * @author Wu
 * @date 2022年09月30日 9:45
 */
public class Solution {
    public Node flatten(Node head) {
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            if (cur.child != null) {
                cur.next = cur.child;
                cur.child.prev = cur;
                Node childTail = cur.child;
                cur.child = null;
                while (childTail.next != null) childTail = childTail.next;
                childTail.next = next;
                if (next != null) next.prev = childTail;
                cur = cur.next;
            } else {
                cur = next;
            }
        }
        return head;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};