package 剑指Offer_专项突击版.链表.链表中的两数相加;

import 剑指Offer_专项突击版.链表.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wu
 * @date 2022年09月29日 13:58
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> left = new LinkedList<>();
        Deque<ListNode> right = new LinkedList<>();
        ListNode leftNode = l1, rightNode = l2;
        while (leftNode != null) {
            left.push(leftNode);
            leftNode = leftNode.next;
        }
        while (rightNode != null) {
            right.push(rightNode);
            rightNode = rightNode.next;
        }
        ListNode pre = null;
        int count = 0;
        while (!left.isEmpty() && !right.isEmpty()) {
            ListNode popL = left.pop();
            ListNode popR = right.pop();
            int sum = popR.val + popL.val + count;
            if (sum >= 10) {
                sum -= 10;
                count = 1;
            } else count = 0;
            ListNode node = new ListNode(sum);
            node.next = pre;
            pre = node;

        }
        while (!left.isEmpty()) {
            ListNode popL = left.pop();
            int sum = popL.val + count;
            if (sum >= 10) {
                sum -= 10;
                count = 1;
            } else count = 0;
            ListNode node = new ListNode(sum);
            node.next = pre;
            pre = node;
        }
        while (!right.isEmpty()) {
            ListNode popR = right.pop();
            int sum = popR.val + count;
            if (sum >= 10) {
                sum -= 10;
                count = 1;
            } else count = 0;
            ListNode node = new ListNode(sum);
            node.next = pre;
            pre = node;
        }

        if (count > 0) {
            ListNode head = new ListNode(1);
            head.next = pre;
            pre = head;
        }
        return pre;
    }
}
