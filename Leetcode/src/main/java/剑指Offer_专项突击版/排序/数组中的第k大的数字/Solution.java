package 剑指Offer_专项突击版.排序.数组中的第k大的数字;

import java.util.Random;

/**
 * @author Wu
 * @date 2022年10月11日 19:17
 */
public class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int quickSelect(int[] nums, int l, int r, int idx) {
        int rand = random.nextInt(r - l + 1) + l;
        swap(nums, rand, l);
        int i = l, j = r, pivot = nums[l];
        while (i < j) {
            while (i < j && nums[j] >= pivot) j--;
            while (i < j && nums[i] <= pivot) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        if (i == idx) return nums[i];
        else {
            return i < idx ? quickSelect(nums, i + 1, r, idx) : quickSelect(nums, l, i - 1, idx);
        }
    }
}