package LeetCode.周赛总.双周赛.双周赛90.下一个更大元素IV;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Wu
 * @date 2022年10月30日 10:20
 */
public class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();

        deque1.add(0);
        for (int i = 1; i < nums.length; i++) {
            while (!deque2.isEmpty() && nums[i] > nums[deque2.peek()]) {
                Integer idx = deque2.pop();
                ans[idx] = nums[i];
            }
            Deque<Integer> tmp = new LinkedList<>();
            while (!deque1.isEmpty() && nums[i] > nums[deque1.peek()]) {
                tmp.push(deque1.pop());
            }
            while (!tmp.isEmpty()) {
                deque2.push(tmp.pop());
            }
            deque1.push(i);
        }
        return ans;
    }
}

