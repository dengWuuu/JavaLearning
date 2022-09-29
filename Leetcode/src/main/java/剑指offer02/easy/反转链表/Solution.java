package 剑指offer02.easy.反转链表;

/**
 * @author Wu
 * @date 2022年07月28日 11:05
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
