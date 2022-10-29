package 字节跳动题库.飞书.下一个排列;

/**
 * @author Wu
 * @date 2022年10月29日 19:38
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int idx = nums.length - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) idx++;
        if (idx >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] > nums[idx]) j--;
            swap(nums, idx, j);
        }
        reverse(nums, idx + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i) {
        int start = i;
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}