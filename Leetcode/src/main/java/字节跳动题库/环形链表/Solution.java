package 字节跳动题库.环形链表;

import 剑指Offer_专项突击版.链表.ListNode;

/**
 * @author Wu
 * @date 2022年11月07日 19:17
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}
