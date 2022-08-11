package LeetCode.热题100.删除链表的倒数第N个结点;

/**
 * @author Wu
 * @date 2022年08月10日 10:56
 */
public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode tmp = head;
        ListNode cur = dummy;
        while (n > 0) {
            tmp = tmp.next;
            n--;
        }
        while (tmp != null) {
            tmp = tmp.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        removeNthFromEnd(head, 2);
    }
}
