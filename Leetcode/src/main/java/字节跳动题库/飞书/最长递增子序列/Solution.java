package 字节跳动题库.飞书.最长递增子序列;

/**
 * @author Wu
 * @date 2022年10月24日 20:17
 */
public class Solution {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int[] tail = new int[n];
        tail[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tail[len - 1]) {
                tail[len++] = nums[i];
            } else {
                int l = 0, r = len - 1;
                while (l <= r) {
                    int mid = (r - l) / 2 + l;
                    if (tail[mid] > nums[i]) {
                        r = mid - 1;
                    } else if (tail[mid] < nums[i]) {
                        l = mid + 1;
                    } else {
                        l = mid;
                        break;
                    }
                }
                tail[l] = nums[i];
            }
        }
        return len;
    }
}