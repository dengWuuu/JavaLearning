package 腾讯题库.寻找旋转排序数组中的最小值;

/**
 * @author Wu
 * @date 2022年11月09日 20:25
 */
public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] > nums[r]) l = mid + 1;
            else r = mid - 1;
        }

        return nums[l];
    }
}