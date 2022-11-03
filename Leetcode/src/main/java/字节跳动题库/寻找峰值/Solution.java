package 字节跳动题库.寻找峰值;

/**
 * @author Wu
 * @date 2022年11月03日 19:07
 */
public class Solution {
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] >= nums[1] ? 0 : 1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
//[1,2,3]