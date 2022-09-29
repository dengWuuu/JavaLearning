package 剑指offer02.easy.和为s的两个数字;

/**
 * @author Wu
 * @date 2022年08月04日 13:05
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) return new int[0];
        int left = 0, right = n - 1;
        while (left < n && right >= 0 && right >= left) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}