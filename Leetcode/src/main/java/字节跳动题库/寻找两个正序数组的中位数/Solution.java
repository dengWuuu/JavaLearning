package 字节跳动题库.寻找两个正序数组的中位数;

public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findK(nums1, nums2, 0, 0, left) + findK(nums1, nums2, 0, 0, right)) / 2.0;
    }

    public static int findK(int[] nums1, int[] nums2, int i, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];

        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        int mid1 = i + k / 2 - 1 < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = j + k / 2 - 1 < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;

        if (mid1 <= mid2) {
            return findK(nums1, nums2, i + k / 2, j, k - k / 2);
        } else {
            return findK(nums1, nums2, i, j + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4}));
    }
}