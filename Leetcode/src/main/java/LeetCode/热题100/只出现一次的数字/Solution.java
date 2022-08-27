package LeetCode.热题100.只出现一次的数字;

/**
 * @author Wu
 * @date 2022年08月24日 13:27
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
