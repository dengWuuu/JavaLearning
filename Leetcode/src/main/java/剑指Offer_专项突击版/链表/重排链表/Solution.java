package 剑指Offer_专项突击版.链表.重排链表;

import 剑指Offer_专项突击版.链表.ListNode;

/**
 * @author Wu
 * @date 2022年09月29日 14:15
 */
public class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = head;
        ListNode last = head.next;
        while(last != null && last.next != null){
            mid = mid.next;
            last = last.next.next;
        }
        ListNode tmp = mid.next;
        mid.next = null;
        ListNode n1 = head,n2 = reverse(tmp);
        while(n1 != null && n2 != null){
            ListNode next = n1.next;
            n1.next = n2;
            n2 = n2.next;
            n1.next.next = next == null ? n1.next.next : next;
            n1 = next;
        }
    }
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
