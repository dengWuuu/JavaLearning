package 代码随想录.动态规划.最长递增子序列;

/**
 * @author Wu
 * @date 2022年09月20日 22:52
 */
public class Solution {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static int resolveByBinarySearch(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) return 0;
        int[] d = new int[n];
        d[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len - 1]) {
                d[len++] = nums[i];
            } else {
                int left = 0, right = len - 1;
                while (left < right) {
                    int mid = (right - left) / 2 + left;
                    if (d[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                d[left] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(resolveByBinarySearch(new int[]{10, 9, 2, 5, 3, 4}));
    }
}
