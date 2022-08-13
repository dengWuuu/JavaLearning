package LeetCode.热题100.搜索插入位置;

/**
 * @author Wu
 * @date 2022年08月12日 14:24
 */
public class Solution {
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left < right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return target == nums[left] ? left : (target > nums[left] ? left + 1 : left);
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
