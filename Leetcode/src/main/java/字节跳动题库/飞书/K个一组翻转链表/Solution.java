package 字节跳动题库.飞书.K个一组翻转链表;

/**
 * @author Wu
 * @date 2022年10月24日 18:50
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);

        ListNode cur = dummy, pre = dummy;
        while (true) {
            for (int i = 0; i < k; i++) {
                if (cur != null) {
                    cur = cur.next;
                } else break;
            }
            if (cur == null) break;
            //cur在尾巴，pre在头
            ListNode preTail = pre;
            pre = pre.next;
            ListNode nextHead = cur.next;
            cur.next = null;
            ListNode[] pairs = reverse(pre);
            preTail.next = pairs[0];
            pairs[1].next = nextHead;

            pre = pairs[1];
            cur = pairs[1];
        }

        return dummy.next;
    }


    public ListNode[] reverse(ListNode head) {
        ListNode[] pair = new ListNode[2];
        ListNode dummy = head;
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        pair[0] = pre;
        pair[1] = dummy;
        return pair;
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