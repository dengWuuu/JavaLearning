package 剑指offer02.easy.从尾到头打印链表_easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年07月23日 20:52
 */
public class Solution {
    public static int[] reversePrint(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head.next != null || head != null) {
            ans.add(head.val);
            head = head.next;
        }

        int[] array = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            array[i] = ans.get(i);
        }
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int tmp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = tmp;
        }
        return array;
    }


}
