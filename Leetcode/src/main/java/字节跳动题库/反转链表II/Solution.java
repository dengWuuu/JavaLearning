package 字节跳动题库.反转链表II;

import 剑指Offer_专项突击版.链表.ListNode;

/**
 * @author Wu
 * @date 2022年11月02日 15:32
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);

        ListNode l = dummy, r = dummy;
        for (int i = 0; i < left - 1; i++) {
            l = l.next;
        }
        r = l;
        for (int i = 0; i < right - left + 1; i++) {
            r = r.next;
        }

        ListNode headL = l.next;
        l.next = null;
        ListNode tailR = r.next;
        r.next = null;

        ListNode[] reverse = reverse(headL);
        l.next = reverse[0];
        reverse[1].next = tailR;


        return dummy.next;
    }


    public ListNode[] reverse(ListNode head) {
        ListNode cur = head, pre = head, tail = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{pre, tail};
    }
}