package LeetCode.周赛总.单周塞.周赛321.题目3;

import 剑指Offer_专项突击版.链表.ListNode;

import java.util.*;

/**
 * @author Wu
 * @date 2022年11月20日 9:56
 */
public class Solution {
    public ListNode removeNodes(ListNode head) {
        int n = 0;
        ListNode q = head;
        List<Integer> list = new ArrayList<>();
        while (q != null) {
            list.add(q.val);
            q = q.next;
            n++;
        }
        boolean[] dp = new boolean[n];
        int max = Integer.MIN_VALUE;
        for (int i = list.size() - 1; i >= 0; i--) {
            max = Math.max(max, list.get(i));
            if (max > list.get(i)) dp[i] = true;
        }
        System.out.println(Arrays.toString(dp));

        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        ListNode next = dummy;
        int idx = -1;
        while (next != null && idx < n) {
            idx++;
            next = next.next;
            if (idx < n && dp[idx]) continue;
            else {
                cur.next = next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

}