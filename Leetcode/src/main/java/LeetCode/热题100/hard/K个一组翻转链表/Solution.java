package LeetCode.热题100.hard.K个一组翻转链表;

/**
 * @author Wu
 * @date 2022年08月11日 12:25
 */
public class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode nextHead = tail.next;
            ListNode[] reverse = reverse(head, tail);

            pre.next = reverse[0];
            reverse[1].next = nextHead;
            pre = reverse[1];
            head = nextHead;
        }
        return dummy.next;
    }

    public static ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode cur = head;
        ListNode pre = tail.next;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }

    public static void main(String[] args) {
        ListNode tail = new ListNode(5);
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, tail))));
        reverseKGroup(head, 2);
    }
}
