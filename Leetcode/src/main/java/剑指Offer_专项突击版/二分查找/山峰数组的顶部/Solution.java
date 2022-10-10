package 剑指Offer_专项突击版.二分查找.山峰数组的顶部;

/**
 * @author Wu
 * @date 2022年10月10日 18:34
 */
public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            if (arr[mid] > arr[mid - 1]) left = mid;
            else right = mid;
        }
        return -1;
    }
}