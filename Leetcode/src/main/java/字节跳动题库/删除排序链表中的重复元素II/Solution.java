package 字节跳动题库.删除排序链表中的重复元素II;

import 剑指Offer_专项突击版.链表.ListNode;

/**
 * @author Wu
 * @date 2022年11月03日 19:31
 */
public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode cur = head, construct = dummy;
        while (cur != null) {
            ListNode next = cur.next;
            if (next != null && next.val == cur.val) {
                while (next != null && next.val == cur.val) {
                    next = next.next;
                }
                cur = next;
            }else {
                construct.next = cur;
                cur.next = null;
                cur = next;
                construct = construct.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(new ListNode(1, new ListNode(2,new ListNode(2)))));
    }
}