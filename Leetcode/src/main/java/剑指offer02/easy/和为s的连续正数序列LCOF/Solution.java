package 剑指offer02.easy.和为s的连续正数序列LCOF;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月04日 13:14
 */
public class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList<>();
        int i = 1, j = 2;
        int sum = 3;
        while (i < j) {
            if (sum == target) {
                int tmp[] = new int[j - i + 1];
                for (int k = i; k < j; k++) {
                    tmp[k - i] = k;
                }
                ans.add(tmp);
            }
            if (sum >= target) {
                sum -= i;
                i++;
            } else {
                j++;
                sum += j;
            }
        }
        return ans.toArray(new int[0][]);
    }
}