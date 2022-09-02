package LeetCode.热题100.寻找重复数;

/**
 * @author Wu
 * @date 2022年08月29日 20:07
 */
public class Solution {
    public static int findDuplicate(int[] nums) {
        int idx = 0;
        while (nums[idx] != -1) {
            if (nums[idx] - 1 == idx) {
                nums[idx] = -1;
                while (nums[idx] == -1) idx++;
            } else {
                int tmp = nums[nums[idx] - 1];
                if (tmp == -1) break;
                nums[nums[idx] - 1] = -1;
                nums[idx] = tmp;
            }
        }
        return nums[idx];
    }
}
