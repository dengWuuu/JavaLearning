package LeetCode.热题100.颜色分类;

/**
 * @author Wu
 * @date 2022年08月18日 11:53
 */
public class Solution {
    public void sortColors(int[] nums) {
        int left = -1, right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 2) {
                right++;
                swap(nums, i, right);
                if (nums[right] < 1) {
                    left++;
                    swap(nums, left, right);
                }
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
