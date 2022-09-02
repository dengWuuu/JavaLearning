package LeetCode.热题100.回文链表;

/**
 * @author Wu
 * @date 2022年08月29日 8:38
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode rightHead = reverse(right);
        while (head != null && rightHead != null) {
            if (head.val != rightHead.val) return false;
            else {
                head = head.next;
                rightHead = rightHead.next;
            }
        }
        return true;
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

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}