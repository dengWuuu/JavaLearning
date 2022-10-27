package 字节跳动题库.飞书.两数相加;

/**
 * @author Wu
 * @date 2022年10月27日 14:57
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = carry + val1 + val2;
            if (sum >= 10) {
                sum %= 10;
                carry = 1;
            } else carry = 0;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            ListNode newNode = new ListNode(sum);
            pre.next = newNode;
            pre = pre.next;
        }
        if (carry > 0) {
            ListNode listNode = new ListNode(carry);
            pre.next = listNode;
        }
        return dummy.next;
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