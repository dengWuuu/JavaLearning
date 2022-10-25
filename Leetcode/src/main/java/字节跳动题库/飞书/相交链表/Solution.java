package 字节跳动题库.飞书.相交链表;

/**
 * @author Wu
 * @date 2022年10月25日 21:55
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headB : b.next;
        }
        return a;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}