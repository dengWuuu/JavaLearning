package 剑指offer02.easy.剑指offer53;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年08月03日 15:55
 */
public class Solution {
    static int n;

    public static int missingNumber(int[] nums) {
        n = nums.length;
        int left = 0, right = n - 1;
        int mid;
        while (left < right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right] == n - 1 && nums[left] == left ? nums[right] + 1 : nums[left] - 1;
    }

    public static void main(String[] args) {
        missingNumber(new int[]{0});
    }
}