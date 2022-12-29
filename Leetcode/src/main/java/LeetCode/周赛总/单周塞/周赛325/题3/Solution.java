package LeetCode.周赛总.单周塞.周赛325.题3;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length, l = 0, r = price[n - 1] - price[0] + 1;

        while (l < r) {
            int mid = (r - l + 1) / 2 + l;
            if (check(price, mid, k)) {
                l = mid;
            } else r = mid - 1;

        }
        return l;
    }

    public boolean check(int[] price, int x, int k) {
        int pre = price[0];
        int cnt = 1;
        for (int i = 1; i < price.length; i++) {
            if (price[i] - pre >= x) {
                cnt++;
                pre = price[i];
            }
        }
        return cnt >= k;
    }
}