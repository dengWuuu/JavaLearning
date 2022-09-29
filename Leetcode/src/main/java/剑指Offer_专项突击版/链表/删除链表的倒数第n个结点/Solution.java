package 剑指Offer_专项突击版.链表.删除链表的倒数第n个结点;

import 剑指Offer_专项突击版.链表.ListNode;

/**
 * @author Wu
 * @date 2022年09月29日 9:50
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        ListNode pre = dummy;
        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
