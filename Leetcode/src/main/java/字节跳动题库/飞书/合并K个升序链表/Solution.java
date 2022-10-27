package 字节跳动题库.飞书.合并K个升序链表;

import 剑指Offer_专项突击版.链表.ListNode;

/**
 * @author Wu
 * @date 2022年10月27日 15:46
 */
public class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {

        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l > r) return null;
        int mid = (r - l) / 2 + l;

        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }


    public static ListNode mergeTwoList(ListNode l, ListNode r) {
        ListNode root = new ListNode(-1), pre = root;
        ListNode left = l, right = r;
        while (left != null && right != null) {
            if (left.val > right.val) {
                pre.next = right;
                right = right.next;
            } else {
                pre.next = left;
                left = left.next;
            }
            pre = pre.next;
        }

        pre.next = left == null ? right : left;
        return root.next;
    }
}
