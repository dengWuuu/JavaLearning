package 剑指offer02.middle.数组中数字出现的次数2;

/**
 * @author Wu
 * @date 2022年08月04日 12:06
 */
public class Solution {

    int[] num = new int[32];

    public static int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public  int singleNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                num[j] += (nums[i] >> j & 1) == 1 ? 1 : 0;
            }
        }
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            ans <<= 1;
            if (num[i] % 3 == 1) {
                ans |= 1;
            }
        }
        return ans;
    }
}