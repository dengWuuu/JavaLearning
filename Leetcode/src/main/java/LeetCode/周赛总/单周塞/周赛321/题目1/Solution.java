package LeetCode.周赛总.单周塞.周赛321.题目1;

/**
 * @author Wu
 * @date 2022年11月20日 9:55
 */
class Solution {
    public int pivotInteger(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans += i;
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum > ans) break;
            }
            if (sum == ans) return i;
        }
        return -1;

    }
}