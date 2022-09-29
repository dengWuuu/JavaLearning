package 剑指offer02.easy.圆圈中最后剩下的数字;

/**
 * @author Wu
 * @date 2022年08月05日 16:29
 */
public class Solution {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % n;
        }
        return x;
    }
}