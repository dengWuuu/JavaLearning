package 代码随想录.贪心.加油站;

/**
 * @author Wu
 * @date 2022年09月16日 10:08
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, curSum = 0, startIdx = 0;
        for (int i = 0; i < cost.length; i++) {
            curSum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (curSum < 0) {
                curSum = 0;
                startIdx = i + 1;
            }
        }
        return total < 0 ? -1 : startIdx;
    }
}
