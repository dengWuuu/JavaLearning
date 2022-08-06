package LeetCode.剑指offer02.easy.扑克牌中的顺子;

import java.util.Arrays;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年08月05日 16:02
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        //0的个数
        int joker = nums[0] == 0 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                joker++;
                continue;
            }
            if (nums[i] == nums[i - 1]) return false;
            if (nums[i] == nums[i - 1] + 1) {
                continue;
            } else {
                if (joker <= 0) return false;
                else joker--;
            }
        }
        return true;
    }
}