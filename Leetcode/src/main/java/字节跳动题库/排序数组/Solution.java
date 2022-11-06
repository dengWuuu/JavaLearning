package 字节跳动题库.排序数组;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Wu
 * @date 2022年11月04日 22:51
 */
public class Solution {

    public int[] sortArray(int[] nums) {
//        quickSort(nums);
        mergeSort(nums);
        return nums;
    }

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, l, i);

        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void mergeSort(int[] nums) {
        int[] tmp = new int[nums.length];
        merge(nums, 0, nums.length - 1, tmp);
    }

    public void merge(int[] nums, int l, int r, int[] tmp) {
        if (l >= r) return;
        int mid = (r - l) / 2 + l;
        merge(nums, l, mid, tmp);
        merge(nums, mid + 1, r, tmp);

        sort(nums, tmp, l, r);
    }

    public void sort(int[] nums, int[] tmp, int l, int r) {
        int right = (r - l) / 2 + l + 1, left = l;
        int mid = right;
        int idx = l;
        while (left < mid && right <= r) {
            if (nums[left] <= nums[right]) {
                tmp[idx] = nums[left];
                left++;
            } else {
                tmp[idx] = nums[right];
                right++;
            }
            idx++;
        }
        for (int i = left; i < mid; i++) {
            tmp[idx] = nums[i];
            idx++;
        }
        for (int i = right; i <= r; i++) {
            tmp[idx] = nums[i];
            idx++;
        }

        if (r + 1 - l >= 0) System.arraycopy(tmp, l, nums, l, r + 1 - l);
    }

}
