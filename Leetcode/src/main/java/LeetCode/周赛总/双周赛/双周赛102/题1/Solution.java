package LeetCode.周赛总.双周赛.双周赛102.题1;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
class Solution {
    public int splitNum(int num) {
        int[] nums = new int[10];
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            nums[str.charAt(i) - '0']++;
        }

        int num1 = 0, num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            for (int j = 0; j < nums[i]; j++) {
                if (num1 <= num2) {
                    num1 = num1 * 10 + i;
                } else {
                    num2 = num2 * 10 + i;
                }
            }
        }
        return num1 + num2;
    }
}