package LeetCode.二零二三年每日一题.删除最短的子数组使剩余数组有序;


/**
 * @author Wu
 * @date 2023年03月25日 11:36
 */
public class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, j = n - 1;
        while (j > 0 && arr[j - 1] <= arr[j]) {
            j--;
        }
        if (j == 0) return 0;

        int res = j;
        for (int i = 0; i < n; i++) {
            while (j < n && arr[j] < arr[i]) {
                j++;
            }
            res = Math.min(res, j - i - 1);
            if (i + 1 < n && arr[i] > arr[i + 1]) break;
        }
        return res;
    }
}