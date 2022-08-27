package LeetCode.热题100.环形链表;

/**
 * @author Wu
 * @date 2022年08月27日 15:32
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next, slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}