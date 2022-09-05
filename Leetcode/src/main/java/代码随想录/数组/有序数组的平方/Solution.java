package 代码随想录.数组.有序数组的平方;

/**
 * @author Wu
 * @date 2022年09月05日 10:14
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] ans = new int[nums.length];
        int idx = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] >= nums[right] * nums[right]) {
                ans[idx--] = nums[left] * nums[left];
                left++;
            } else {
                ans[idx--] = nums[right] * nums[right];
                right--;
            }
        }
        return ans;
    }
}
