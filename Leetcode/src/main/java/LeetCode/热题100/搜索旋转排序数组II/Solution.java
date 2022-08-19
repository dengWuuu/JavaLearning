package LeetCode.热题100.搜索旋转排序数组II;

/**
 * @author Wu
 * @date 2022年08月19日 15:25
 */
public class Solution {
    public static boolean search(int[] nums, int target) {
        return binary(0, nums.length - 1, nums, target);
    }

    public static boolean binary(int left, int right, int[] nums, int target) {
        if (left > right) return false;
        while (left < right && nums[left] == nums[left + 1]) {
            ++left;
        }
        while (left < right && nums[right] == nums[right - 1]) {
            --right;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return true;

        if (nums[mid] >= nums[left]) {
            if (target < nums[mid] && target >= nums[left]) return binary(left, mid - 1, nums, target);
            else return binary(mid + 1, right, nums, target);
        }

        if (nums[mid] < nums[left]) {
            if (target > nums[mid] && target <= nums[right]) return binary(mid + 1, right, nums, target);
            else return binary(left, mid - 1, nums, target);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 1}, 1));
    }
}