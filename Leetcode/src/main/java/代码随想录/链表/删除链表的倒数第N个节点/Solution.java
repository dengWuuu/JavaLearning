package 代码随想录.链表.删除链表的倒数第N个节点;

import 代码随想录.链表.ListNode;

import java.util.List;

/**
 * @author Wu
 * @date 2022年09月05日 20:26
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy, tmp = dummy;
        for (int i = 0; i < n; i++) {
            tmp = tmp.next;
        }
        while (tmp.next != null) {
            tmp = tmp.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
