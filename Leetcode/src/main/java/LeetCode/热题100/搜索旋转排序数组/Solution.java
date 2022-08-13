package LeetCode.热题100.搜索旋转排序数组;

/**
 * @author Wu
 * @date 2022年08月12日 12:31
 */
public class Solution {
    public static int search(int[] nums, int target) {
        return binary(nums, 0, nums.length - 1, target);
    }

    public static int binary(int[] nums, int left, int right, int target) {
        int mid = (right - left) / 2 + left;
        if (left > right) return -1;
        if (nums[mid] == target) return mid;
        if (nums[mid] <= nums[right]) {
            if (nums[mid] < target && target <= nums[right]) {
                return binary(nums, mid + 1, right, target);
            } else {
                return binary(nums, left, mid - 1, target);
            }
        } else {
            if (nums[left] <= target && target < nums[mid]) {
                return binary(nums, left, mid - 1, target);
            } else {
                return binary(nums, mid + 1, right, target);
            }
        }
    }

    public static void main(String[] args) {
        search(new int[]{10, 11, 12, 13, 14, 15, 1, 2, 3, 4}, 4);
    }
}
