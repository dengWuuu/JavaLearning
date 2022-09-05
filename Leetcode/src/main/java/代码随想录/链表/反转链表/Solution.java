package 代码随想录.链表.反转链表;

import 代码随想录.链表.ListNode;

/**
 * @author Wu
 * @date 2022年09月05日 20:06
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
