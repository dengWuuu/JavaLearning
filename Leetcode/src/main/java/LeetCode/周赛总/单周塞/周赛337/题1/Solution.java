package LeetCode.周赛总.单周塞.周赛337.题1;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int[] evenOddBit(int n) {
        String s = Integer.toBinaryString(n);

        int[] ans = new int[2];
        StringBuilder str = new StringBuilder(s);
        StringBuilder reverse = str.reverse();
        s = reverse.toString();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (i % 2 == 0) {
                    ans[0]++;
                } else ans[1]++;
            }
        }
        return ans;
    }
}