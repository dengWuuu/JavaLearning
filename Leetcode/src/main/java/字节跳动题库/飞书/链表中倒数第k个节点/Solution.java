package 字节跳动题库.飞书.链表中倒数第k个节点;

import 剑指Offer_专项突击版.链表.ListNode;

/**
 * @author Wu
 * @date 2022年10月31日 20:11
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}