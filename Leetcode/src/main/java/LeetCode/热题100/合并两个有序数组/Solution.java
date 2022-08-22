package LeetCode.热题100.合并两个有序数组;

/**
 * @author Wu
 * @date 2022年08月21日 13:33
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1, right = n - 1;
        int tail = m + n - 1;
        while (left >= 0 && right >= 0) {
            if (nums1[left] > nums2[right]) {
                nums1[tail--] = nums1[left--];
            } else {
                nums1[tail--] = nums2[right--];
            }
        }

        while (right >= 0) {
            nums1[tail--] = nums2[right--];
        }
    }
}
