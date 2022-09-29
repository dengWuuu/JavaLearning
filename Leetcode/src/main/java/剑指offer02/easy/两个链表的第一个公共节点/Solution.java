package 剑指offer02.easy.两个链表的第一个公共节点;

/**
 * @author Wu
 * @date 2022年08月03日 13:07
 */
public class Solution {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
}