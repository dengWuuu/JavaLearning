package LeetCode.周赛总.双周赛.双周赛99.题3;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
class Solution {
    public long findScore(int[] nums) {
        long ans = 0;
        int[][] arr = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);

        boolean[] isVisited = new boolean[nums.length];
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i][1];
            if (isVisited[idx]) continue;
            isVisited[idx] = true;
            num++;
            ans += nums[idx];
            if (idx + 1 < arr.length) {
                if (!isVisited[idx + 1]) {
                    isVisited[idx + 1] = true;
                    num++;
                }
            }
            if (idx - 1 >= 0) {
                if (!isVisited[idx - 1]) {
                    isVisited[idx - 1] = true;
                    num++;
                }
            }
            if (num == arr.length) break;
        }
        return ans;
    }
}