package 代码随想录.单调栈.下一个更大元素I;

import java.util.*;

/**
 * @author Wu
 * @date 2022年09月23日 10:04
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        if (nums1.length == 0) return ans;
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            cache.put(nums1[i], i);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            if (!stack.isEmpty() && nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    if (cache.containsKey(nums2[stack.peek()])) {
                        ans[cache.get(nums2[stack.peek()])] = nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
