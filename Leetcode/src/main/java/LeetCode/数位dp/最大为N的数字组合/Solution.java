package LeetCode.数位dp.最大为N的数字组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月25日 14:42
 */
public class Solution {
    int[] nums;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        nums = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            nums[i] = Integer.parseInt(digits[i]);
        }
        return dp(n);
    }

    int dp(int max) {
        List<Integer> divide = new ArrayList<>();
        while (max != 0) {
            divide.add(max % 10);
            max /= 10;
        }
        int n = divide.size(), m = nums.length, ans = 0;

        //位数和x相同
        for (int i = n - 1, p = 1; i >= 0; i--, p++) {
            int curNum = divide.get(i);
            int l = 0, r = m - 1;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (nums[mid] > curNum) r = mid - 1;
                else if (nums[mid] < curNum) l = mid + 1;
                else {
                    r = mid;
                    break;
                }
            }
            if (r == -1) {
                break;
            } else if (nums[r] == curNum) {
                ans += r * (int) Math.pow(m, (n - p));
                if (i == 0) ans++;
            } else if (nums[r] < curNum) {
                ans += (r + 1) * (int) Math.pow(m, (n - p));
                break;
            }

        }
        // 位数比 x 少的
        for (int i = 1, last = 1; i < n; i++) {
            int cur = last * m;
            ans += cur;
            last = cur;
        }
        return ans;
    }
}
