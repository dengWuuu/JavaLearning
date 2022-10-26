package 字节跳动题库.飞书.缺失的第一个正数;

/**
 * @author Wu
 * @date 2022年10月26日 14:53
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] < nums.length && nums[i] > 0&&! (nums[i] == nums[nums[i] - 1])) {
                if (nums[i] == i + 1) break;
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) continue;
            else return i + 1;
        }
        return nums.length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}