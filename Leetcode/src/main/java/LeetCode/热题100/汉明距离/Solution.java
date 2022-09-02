package LeetCode.热题100.汉明距离;

/**
 * @author Wu
 * @date 2022年09月01日 20:31
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int ans = 0;
        while (xor != 0) {
            xor &= xor - 1;
            ans++;
        }
        return ans;
    }
}
