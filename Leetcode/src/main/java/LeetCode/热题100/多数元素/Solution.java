package LeetCode.热题100.多数元素;

/**
 * @author Wu
 * @date 2022年08月27日 20:24
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
