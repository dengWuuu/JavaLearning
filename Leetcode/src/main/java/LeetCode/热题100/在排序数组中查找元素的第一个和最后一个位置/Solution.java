package LeetCode.热题100.在排序数组中查找元素的第一个和最后一个位置;

/**
 * @author Wu
 * @date 2022年08月12日 12:54
 */
public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) break;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        if (left > right) return new int[]{-1, -1};
        int tmp = mid;
        while (tmp <= nums.length - 2) {
            if (nums[tmp + 1] == target) {
                tmp++;
            } else break;
        }
        right = tmp;
        tmp = mid;
        while (tmp >= 1) {
            if (nums[tmp - 1] == target) {
                tmp--;
            } else break;
        }
        left = tmp;
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        searchRange(new int[]{2, 2}, 2);
    }
}
