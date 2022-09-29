package 剑指offer02.easy.二进制中1的个数;

/**
 * @author Wu
 * @date 2022年07月25日 14:42
 */
public class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n&=n-1;
            ans++;
        }
        return ans;
    }
}
