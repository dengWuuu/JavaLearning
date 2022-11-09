package 腾讯题库.排序数组_堆排序;

class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    public void heapSort(int[] nums) {
        buildHeap(nums);
        int len = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            len--;
            percolateDown(nums, 0, len);
        }

    }

    public void percolateDown(int[] nums, int i, int len) {
        int parent = i, children = 2 * i + 1;
        while (children < len) {
            if (children + 1 < len && nums[children + 1] > nums[children]) {
                children++;
            }
            if (nums[children] > nums[parent]) {
                swap(nums, parent, children);
                parent = children;
                children = 2 * parent + 1;
            } else break;
        }
    }

    public void buildHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            percolateDown(nums, i, nums.length);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}