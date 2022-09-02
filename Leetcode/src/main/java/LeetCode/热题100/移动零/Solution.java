package LeetCode.热题100.移动零;

/**
 * @author Wu
 * @date 2022年08月29日 19:43
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0, n = nums.length;
        while (left < n && right < n) {
            while (left < n && nums[left] != 0) left++;
            if (right < left) right = left + 1;
            while (right < n && nums[right] == 0) right++;
            if (left < right && left < n && right < n) swap(nums, left, right);
            left++;
            right++;
        }
    }


    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
