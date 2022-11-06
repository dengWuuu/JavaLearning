package LeetCode.周赛总.单周塞.周赛318.对数组执行操作;

/**
 * @author Wu
 * @date 2022年11月06日 10:30
 */
public class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int s = 0, f = 0;
        while (f < nums.length) {
            while (nums[s] != 0) s++;
            f = s;
            while (f < nums.length && nums[f] == 0) f++;
            if (f < nums.length) swap(nums, s, f);
        }

        return nums;
    }

    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}