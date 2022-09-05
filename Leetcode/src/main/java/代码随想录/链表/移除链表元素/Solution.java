package 代码随想录.链表.移除链表元素;

import 代码随想录.链表.ListNode;

/**
 * @author Wu
 * @date 2022年09月05日 19:50
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = head, pre = dummy;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }

        }
        return dummy.next;
    }
}
