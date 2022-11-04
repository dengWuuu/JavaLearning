package 字节跳动题库.环形链表II;

import 剑指Offer_专项突击版.链表.ListNode;

/**
 * @author Wu
 * @date 2022年11月04日 22:20
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) return null;
        ListNode cur = head;
        while (cur != fast) {
            cur = cur.next;
            fast = fast.next;
        }
        return cur;
    }
}