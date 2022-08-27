package LeetCode.热题100.排序链表;

/**
 * @author Wu
 * @date 2022年08月27日 18:28
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode midNext = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(midNext);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return dummy.next;
    }
}
