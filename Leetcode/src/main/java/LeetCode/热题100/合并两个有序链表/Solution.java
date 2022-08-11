package LeetCode.热题100.合并两个有序链表;

/**
 * @author Wu
 * @date 2022年08月10日 15:13
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        ListNode left = list1, right = list2;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tmp.next = left;
                left = left.next;
            } else {
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }

        while (right != null) {
            tmp.next = right;
            right = right.next;
            tmp = tmp.next;
        }

        while (left != null) {
            tmp.next = left;
            left = left.next;
            tmp = tmp.next;
        }
        return dummy.next;
    }
}
