package 剑指Offer_专项突击版.数组.前n个数字二进制中1的个数;

/**
 * @author Wu
 * @date 2022年09月26日 18:35
 */
public class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
