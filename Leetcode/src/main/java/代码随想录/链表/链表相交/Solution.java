package 代码随想录.链表.链表相交;

import 代码随想录.链表.ListNode;

/**
 * @author Wu
 * @date 2022年09月05日 20:32
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
}
