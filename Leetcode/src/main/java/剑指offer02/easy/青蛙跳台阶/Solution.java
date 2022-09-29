package 剑指offer02.easy.青蛙跳台阶;

/**
 * @author Wu
 * @date 2022年07月24日 12:18
 */
public class Solution {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int MOD = (int) (1e9 + 7);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }
}