package 字节跳动题库.飞书.数组中的第K个最大元素;

/**
 * @author Wu
 * @date 2022年10月25日 19:47
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;
        int l = 0, r = nums.length - 1;
        while (true) {
            int idx = partition(nums, l, r);
            if (idx == target) {
                return nums[idx];
            } else if (idx > target) r = idx - 1;
            else l = idx + 1;
        }
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= pivot) j--;
            while (i < j && nums[i] <= pivot) i++;
            swap(nums, i, j);
        }
        swap(nums, l, i);
        return i;
    }


    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
