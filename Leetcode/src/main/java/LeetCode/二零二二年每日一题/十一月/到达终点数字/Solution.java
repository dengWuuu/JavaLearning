package LeetCode.二零二二年每日一题.十一月.到达终点数字;

/**
 * @author Wu
 * @date 2022年11月04日 9:42
 */
public class Solution {
    public int reachNumber(int target) {
        if (target < 0) target = -target;

        int sum = 0, n = 0;

        while (sum < target || (sum - target) % 2 == 1) {
            sum += ++n;
        }
        return n;
    }
}
