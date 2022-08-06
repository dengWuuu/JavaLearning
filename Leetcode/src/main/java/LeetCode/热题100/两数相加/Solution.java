package LeetCode.热题100.两数相加;

/**
 * @author Wu
 * @date 2022年08月06日 16:16
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode head = ans;
        int flag = 0;
        while (l1 != null && l2 != null) {
            ListNode next;
            if (l1.val + l2.val + flag >= 10) {
                next = new ListNode(l1.val + l2.val + flag - 10);
                flag = 1;
            } else {
                next = new ListNode(l1.val + l2.val + flag);
                flag = 0;
            }
            ans.next = next;
            ans = ans.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            ListNode next = new ListNode(l1.val + flag >= 10 ? l1.val + flag - 10 : l1.val + flag);
            flag = l1.val + flag >= 10 ? 1 : 0;
            ans.next = next;
            ans = ans.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            ListNode next = new ListNode(l2.val + flag >= 10 ? l2.val + flag - 10 : l2.val + flag);
            flag = l2.val + flag >= 10 ? 1 : 0;
            ans.next = next;
            ans = ans.next;
            l2 = l2.next;
        }
        if (flag == 1) {
            ans.next = new ListNode(1);
        }
        return head.next;
    }
}
