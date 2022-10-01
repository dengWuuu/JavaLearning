package 剑指Offer_专项突击版.链表.排序的循环链表;


import 剑指Offer_专项突击版.链表.Node;

/**
 * @author Wu
 * @date 2022年09月30日 9:56
 */
public class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node max = head, min;
        Node cur = head;
        while (cur != null) {
            if (cur.val <= insertVal && insertVal <= cur.next.val) break;
            cur = cur.next;
            if (cur.val >= max.val) max = cur;
            if (cur == head) break;
        }
        min = max.next;
        if (cur == head) {
            max.next = newNode;
            newNode.next = min;
        } else {
            Node next = cur.next;
            cur.next = newNode;
            newNode.next = next;
        }
        return head;
    }
}
