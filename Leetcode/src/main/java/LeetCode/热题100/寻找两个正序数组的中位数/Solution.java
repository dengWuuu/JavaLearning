package LeetCode.热题100.寻找两个正序数组的中位数;

/**
 * @author Wu
 * @date 2022年08月06日 17:45
 */
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int left = (n1 + n2 + 1) / 2, right = (n1 + n2 + 2) / 2;
        return (findKth(nums1, nums2, 0, 0, left) + findKth(nums1, nums2, 0, 0, right)) / 2.0;
    }

    public static int findKth(int[] nums1, int[] nums2, int i, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];

        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int mid1 = i + k / 2 - 1 < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = j + k / 2 - 1 < nums2.length ? nums2[i + k / 2 - 1] : Integer.MAX_VALUE;

        if (mid1 < mid2) {
            return findKth(nums1, nums2, i + k / 2, j, k - k / 2);
        } else {
            return findKth(nums1, nums2, i, j + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7});
    }
}