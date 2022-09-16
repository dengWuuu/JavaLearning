package 代码随想录.贪心.摆动序列;

/**
 * @author Wu
 * @date 2022年09月15日 9:41
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int preDiff = 0, curDiff = 0;
        int ans = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                ans++;
                preDiff = curDiff;
            }
        }
        return ans;
    }
}
