package 代码随想录.额外的题目.有多少小于当前数字的数字;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Wu
 * @date 2022年09月23日 22:03
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[][] data = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        Arrays.sort(data, Comparator.comparingInt(x -> x[0]));

        int[] ans = new int[nums.length];
        int prev = -1;
        for (int i = 0; i < ans.length; i++) {
            if (prev == -1 || data[i][0] != data[i - 1][0]) {
                prev = i;
            }
            int idx = data[i][1];
            ans[idx] = prev;
        }
        return ans;
    }
}
