package LeetCode.热题100.数组中的第K个最大元素;

import java.util.Random;

/**
 * @author Wu
 * @date 2022年08月28日 14:12
 */
public class Solution {
    private final static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0, right = len - 1;

        while (true) {
            int partition = partition(nums, left, right);
            if (partition == target) return nums[target];

            else if (partition < target) left = partition + 1;
            else right = partition - 1;
        }
    }


    private int partition(int[] nums, int left, int right) {
        int randomPivot = left + random.nextInt(right - left + 1);
        swap(nums, left, randomPivot);

        int pivot = nums[left];
        int i = left, j = right;

        while (i < j) {
            while (i < j && nums[j] >= pivot) j--;
            while (i < j && nums[i] <= pivot) i++;
            swap(nums, i, j);
        }
        swap(nums, left, i);
        return i;
    }


    /**
     * 下面是用小根堆的解法
     */
    private void percolateDown(int[] nums, int i, int len) {
        int parent = i, children = 2 * i + 1;
        while (children < len) {
            if (children + 1 < len && nums[children + 1] < nums[children]) {
                children++;
            }
            if (nums[children] < nums[parent]) {
                swap(nums, children, parent);
                parent = children;
                children = 2 * parent + 1;
            } else break;
        }
    }

    public int findKthSolution(int[] nums, int k) {
        for (int i = k / 2 - 1; i >= 0; i--) {
            percolateDown(nums, i, k);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                swap(nums, i, 0);
                percolateDown(nums, 0, k);
            }
        }
        return nums[0];
    }


    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}