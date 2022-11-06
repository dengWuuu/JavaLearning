package LeetCode.周赛总.单周塞.周赛313.公因子的数目;

/**
 * @author Wu
 * @date 2022年10月02日 10:30
 */
public class Solution {
    public int commonFactors(int a, int b) {
        int ans = 1;
        int n = Math.min(a, b);
        for (int i = 2; i <= n; i++) {
            if (a % i == 0 && (b % i) == 0) ans++;
        }
        return ans;
    }
}
