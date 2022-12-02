package LeetCode.二零二二年每日一题.十二月.移动所有球到每个盒子所需的最小操作数;

import java.util.Map;

/**
 * @author Wu
 * @date 2022年12月02日 10:56
 */
public class Solution {
    public int[] minOperations(String boxes) {
        char[] arr = boxes.toCharArray();
        int n = boxes.length();
        int[] ans = new int[n];
        int operations = 0, right = 0, left = arr[0] - '0';
        for (int i = 1; i < n; i++) {
            if (arr[i] == '1') {
                operations += i;
                right++;
            }
        }
        ans[0] = operations;

        for (int i = 1; i < n; i++) {
            operations += left - right;
            if (arr[i] == '1') {
                right--;
                left++;
            }
            ans[i] = operations;
        }

        return ans;
    }
}