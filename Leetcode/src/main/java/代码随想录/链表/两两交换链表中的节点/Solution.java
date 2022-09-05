package 代码随想录.链表.两两交换链表中的节点;

import 代码随想录.链表.ListNode;

/**
 * @author Wu
 * @date 2022年09月05日 20:08
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode tmp = cur.next;
            ListNode next = tmp.next;
            cur.next = tmp.next;
            tmp.next = next.next;
            next.next = tmp;
            cur = tmp;
        }
        return dummy.next;
    }
}
