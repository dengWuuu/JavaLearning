package LeetCode.热题100.两两交换链表中的节点;

/**
 * @author Wu
 * @date 2022年08月11日 12:05
 */
public class Solution {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode left = temp.next;
            ListNode right = temp.next.next;
            temp.next = right;
            left.next = right.next;
            right.next = left;
            temp = left;
        }
        return dummy.next;
    }
}
