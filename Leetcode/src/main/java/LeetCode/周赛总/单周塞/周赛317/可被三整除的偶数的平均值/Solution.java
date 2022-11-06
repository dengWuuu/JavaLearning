package LeetCode.周赛总.单周塞.周赛317.可被三整除的偶数的平均值;

/**
 * @author Wu
 * @date 2022年10月30日 10:30
 */
public class Solution {
    public int averageValue(int[] nums) {
        long ans = 0;
        int idx = 0;
        for (int num : nums) {
            if (num % 2 == 0 && num % 3 == 0) {
                ans += num;
                idx++;
            }
        }
        return idx == 0 ? 0 : (int) (ans / idx);
    }
}