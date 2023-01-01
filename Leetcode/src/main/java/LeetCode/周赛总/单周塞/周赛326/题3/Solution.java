package LeetCode.周赛总.单周塞.周赛326.题3;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int minimumPartition(String s, int k) {
        int l = 0, r = 0;
        long ans = 0;
        while (l < s.length() && r < s.length()) {
            if (Integer.parseInt(String.valueOf(s.charAt(l))) > k) return -1;
            while (r < s.length() && Long.parseLong(s.substring(l, r + 1)) <= k) {
                r++;
            }
            ans++;
            l = r;
        }
        return (int) ans;
    }
}