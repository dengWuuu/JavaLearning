package LeetCode.热题100.hard.合并K个升序链表;

/**
 * @author Wu
 * @date 2022年08月11日 11:53
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] listNodes, int l, int r) {
        if (l == r) return listNodes[l];
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(listNodes, l, mid), merge(listNodes, mid + 1, r));
    }


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
