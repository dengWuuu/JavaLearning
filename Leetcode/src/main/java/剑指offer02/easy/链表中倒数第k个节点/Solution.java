package 剑指offer02.easy.链表中倒数第k个节点;

/**
 * @author Wu
 * @date 2022年07月28日 11:01
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
