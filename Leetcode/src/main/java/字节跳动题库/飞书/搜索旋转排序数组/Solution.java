package 字节跳动题库.飞书.搜索旋转排序数组;

/**
 * @author Wu
 * @date 2022年10月27日 14:31
 */
public class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) return mid;
            else {
                if (nums[mid] <= nums[r]) {
                    if (target > nums[mid] && target <= nums[r]) l = mid + 1;
                    else r = mid - 1;
                } else {
                    if (target < nums[mid] && target >= nums[l]) r = mid - 1;
                    else l = mid + 1;
                }
            }
        }
        return -1;
    }
}