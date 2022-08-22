package LeetCode.热题100.分隔链表;

/**
 * @author Wu
 * @date 2022年08月20日 20:19
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode cur = head, scur = small, bcur = big;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val >= x) {
                bcur.next = cur;
                bcur = bcur.next;
            } else {
                scur.next = cur;
                scur = scur.next;
            }
            cur.next = null;
            cur = next;
        }
        scur.next = big.next;
        return small.next;
    }
}
