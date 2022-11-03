package 字节跳动题库.排序奇升偶降链表;

import 剑指Offer_专项突击版.链表.ListNode;

/**
 * @author Wu
 * @date 2022年11月03日 14:42
 */

/*
奇偶生序倒序链表的重新排序组合，例如：18365472（2020.08 字节跳动-后端）[3]
1->4->3->2->5 给定一个链表奇数部分递增，偶数部分递减，要求在O(n)时间复杂度内将链表变成递增，5分钟左右（2020.07 字节跳动-测试开发）[4]
 */
public class Solution {
    public ListNode solution(ListNode head) {

        ListNode cur = head;

        ListNode jiHead = new ListNode(-1);
        ListNode ouHead = new ListNode(-1);
        ListNode ji = jiHead, ou = ouHead;
        while (cur != null) {
            ListNode next = cur.next;

            if (cur.val % 2 == 0) {
                ou.next = cur;
                ou = ou.next;
                ou.next = null;
            } else {
                ji.next = cur;
                ji = ji.next;
                ji.next = null;
            }
            cur = next;
        }

        ListNode newHead = ouHead.next;
        ouHead.next = null;
        ouHead = newHead;

        ListNode reverse = reverse(ouHead);


        return mergeTwoList(reverse, jiHead.next);

    }

    public ListNode mergeTwoList(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        if (l == null) {
            cur.next = r;
        } else {
            cur.next = l;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
