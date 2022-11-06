package LeetCode.周赛总.单周塞.米哈游单周赛.恰好移动k步到达某一位置的方法数目;

/**
 * @author Wu
 * @date 2022年09月04日 10:41
 */
public class Solution {

    int MOD = (int) (1e9 + 7);

    public int numberOfWays(int startPos, int endPos, int k) {
        int distance = Math.abs(endPos - startPos);
        if ((distance + k) % 2 != 0 || distance > k) return 0;
        int[][] dp = new int[1001][3001];
        startPos += 1001;
        endPos += 1001;
        return 0;
    }


}
