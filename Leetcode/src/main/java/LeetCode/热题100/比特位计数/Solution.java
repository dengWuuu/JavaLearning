package LeetCode.热题100.比特位计数;

/**
 * @author Wu
 * @date 2022年08月31日 12:13
 */
public class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }
}
