package LeetCode.周赛总.单周塞.周赛338.题2;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    boolean[] zhishu;

    public boolean primeSubOperation(int[] nums) {
        find();
        for (int i = 1000; i >= 0; i--) {
            if (zhishu[i] && nums[0] - i > 0) {
                nums[0] -= i;
                break;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 1000; j >= 0; j--) {
                if (j > num) continue;
                if (zhishu[j] && num - j > nums[i - 1]) {
                    num -= j;
                    break;
                }
            }
            nums[i] = num;
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) return false;
        }
        return true;
    }

    public void find() {
        int n = 1000; //1000以下的质数
        zhishu = new boolean[n + 1];
        Arrays.fill(zhishu, true);
        zhishu[0] = false;
        zhishu[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (zhishu[i]) {
                for (int j = i * i; j <= n; j += i) {
                    zhishu[j] = false;
                }
            }
        }
    }
}