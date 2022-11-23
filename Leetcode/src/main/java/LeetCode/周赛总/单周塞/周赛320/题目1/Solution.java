package LeetCode.周赛总.单周塞.周赛320.题目1;

/**
 * @author Wu
 * @date 2022年11月20日 9:55
 */
public class Solution {
    public static int unequalTriplets(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) break;
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(unequalTriplets(new int[]{4, 4, 2, 4, 3}));
    }
}