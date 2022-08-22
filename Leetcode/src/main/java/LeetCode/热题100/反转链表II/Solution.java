package LeetCode.热题100.反转链表II;

/**
 * @author Wu
 * @date 2022年08月22日 13:16
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        pre.next = null;
        rightNode.next = null;
        reverse(leftNode);

        pre.next = rightNode;
        leftNode.next = curr;
        return dummy.next;
    }

    public void reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
