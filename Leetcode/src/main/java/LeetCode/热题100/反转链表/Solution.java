package LeetCode.热题100.反转链表;

/**
 * @author Wu
 * @date 2022年08月28日 8:01
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
