package 剑指offer02.easy.在排序数组中查找数字1;

/**
 * @author Wu
 * @date 2022年08月03日 13:16
 */
public class Solution {
    static int n;

    public static int search(int[] nums, int target) {
        n = nums.length;
        if (n == 0) {
            return 0;
        }
        int left = 0, right = n - 1;
        int ans = 0;
        int mid = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int tmp = mid - 1;
        while (tmp >= 0 && nums[tmp--] == target) {
            ans++;
        }
        while (mid < n && nums[mid++] == target) {
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        search(new int[]{1,4}, 4);
    }
}