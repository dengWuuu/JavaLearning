package LeetCode.周赛总.双周赛.双周赛93.题4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
public class Solution {
    public static long minimumTotalCost(int[] nums1, int[] nums2) {
        int ans = 0;
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            if (nums1[i] != nums2[i]) continue;
            else {
                int a = -1, b = -1;
                int i1 = 0, j1 = 0, i2 = 0, j2 = 0;
                for (int j = 0; j < n; j++) {
                    if (j == i) continue;
                    if (nums1[j] == nums1[i]) continue;
                    if (nums1[i] != nums2[j]) {
                        a = j + i;
                        j1 = j;
                        i1 = i;
                        break;
                    }
                }

                for (int j = 0; j < n; j++) {
                    if (j == i) continue;
                    if (nums2[j] == nums2[i]) continue;
                    if (nums2[i] != nums1[j]) {
                        b = i + j;
                        j2 = j;
                        i2 = i;
                        break;
                    }
                }
                if (a == -1 || b == -1) return -1;
                if (a < b) {
                    ans += a;
                    swap(nums1, i1, j1);
                } else {
                    ans += b;
                    swap(nums2, i2, j2);
                }

            }
        }

        return ans;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(minimumTotalCost(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}));
    }
}