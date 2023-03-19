package LeetCode.周赛总.双周赛.双周赛100.题2;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
public class Solution {
    public long coloredCells(int n) {
        long ans = 1;
        int cnt = 4;
        for (int i = 1; i < n; i++) {
            ans += cnt;
            cnt += 4;
        }
        return ans;
    }
}