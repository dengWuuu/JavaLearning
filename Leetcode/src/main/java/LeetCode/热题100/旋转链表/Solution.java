package LeetCode.热题100.旋转链表;

/**
 * @author Wu
 * @date 2022年08月16日 19:17
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }
        int nums = n - (k % n);
        if (n == nums) return head;
        cur.next = head;
        while (nums-- > 0) cur = cur.next;
        ListNode ans = cur.next;
        cur.next = null;
        return ans;
    }
}