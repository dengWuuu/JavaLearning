package 代码随想录.动态规划.爬楼梯;

/**
 * @author Wu
 * @date 2022年09月17日 11:59
 */
public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int p = 1, q = 2, r = 0;
        for (int i = 1; i <= n; i++) {
            r = p + q;
            p = q;
            q = r;
        }
        return r;
    }
}