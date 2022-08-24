package LeetCode.热题100.最长连续序列;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年08月24日 12:17
 */
public class Solution {
    int ans = Integer.MIN_VALUE;
    Set<Integer> set = new HashSet<>();

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        for (int num : nums) {
            set.add(num);
        }
        for (Integer integer : set) {
            if (!set.contains(integer - 1)) {
                int currentNum = integer;
                int currentLong = 1;
                while (set.contains(currentNum + 1)) {
                    currentLong++;
                    currentNum++;
                }
                ans = Math.max(ans, currentLong);
            }
        }
        return ans;
    }
}
