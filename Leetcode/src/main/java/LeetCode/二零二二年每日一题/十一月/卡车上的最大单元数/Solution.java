package LeetCode.二零二二年每日一题.十一月.卡车上的最大单元数;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年11月15日 10:41
 */
public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (x, y) -> {
            return y[1] - x[1];
        });
        int ans = 0;
        System.out.print(Arrays.deepToString(boxTypes));
        int idx = 0;
        for (int i = 0; i < truckSize; i++) {
            if (boxTypes[idx][0] > 0) {
                ans += boxTypes[idx][1];
                boxTypes[idx][0]--;
            } else {
                idx++;
                if (idx >= boxTypes.length) break;
                ans += boxTypes[idx][1];
                boxTypes[idx][0]--;
            }
        }

        return ans;
    }
}