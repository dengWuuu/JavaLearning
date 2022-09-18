package 代码随想录.动态规划.斐波那契数;

/**
 * @author Wu
 * @date 2022年09月17日 11:19
 */
public class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int p = 0, q = 1, r = 0;
        for (int i = 2; i <= n; i++) {
            r = p + q;
            p = q;
            q = r;
        }
        return r;
    }
}