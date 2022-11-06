package LeetCode.周赛总.单周塞.周赛316.最大公因数等于K的子数组数目;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年10月23日 10:40
 */
public class Solution {
    public static int subarrayGCD(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0] == k ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % k == 0) {
                if (nums[i] == k) {
                    dp[i] = 1;
                    for (int j = i - 1; j >= 0; j--) {
                        if (gcd(nums[i], nums[j]) == k) {
                            dp[i]++;
                        } else break;
                    }
                } else {
                    dp[i] = 0;
                    for (int j = i - 1; j >= 0; j--) {
                        if (judge(nums, j, i, k)) {
                            dp[i]++;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i : dp) {
            ans += i;
        }
        return ans;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static boolean judge(int[] num, int i, int j, int x) {
        int c = num[i];
        for (int k = i + 1; k <= j; k++) {
            c = gcd(c, num[k]);
        }
        return c == x;
    }

    public static void main(String[] args) {
        System.out.println(subarrayGCD(new int[]{4, 3, 1, 3, 3}, 1));
    }
}
